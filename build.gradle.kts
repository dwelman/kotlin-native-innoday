val ktor_version: String by project
val kotest_version: String by project
val logback_version: String by project

plugins {
    kotlin("multiplatform") version "1.7.20"
    id("io.kotest.multiplatform") version "5.5.2"
    application
}

group = "me.bjorn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    val nativeTarget = when (System.getProperty("os.name")) {
        "Mac OS X" -> linuxX64("native")
        "Linux" -> linuxX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-server-cio:$ktor_version")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("io.kotest:kotest-framework-engine:$kotest_version")
                implementation("io.kotest:kotest-assertions-core:$kotest_version")

                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val nativeMain by getting {
            dependencies {
                dependsOn(commonMain)
                implementation("io.ktor:ktor-server-core:$ktor_version")

            }
        }
        val nativeTest by getting {
            dependsOn(commonTest)
        }
        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
                implementation("ch.qos.logback:logback-classic:$logback_version")
            }
        }
        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation("io.kotest:kotest-runner-junit5:$kotest_version")
            }
        }
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}