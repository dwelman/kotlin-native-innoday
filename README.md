# kotlin-native-innoday
Kotlin Native Innovation day project for Xebia 23/10/2022

## Native Container

Build container:
`docker build -t kotlin-inno-native -f Dockerfile-linux .`

Run container:
`docker run -p 8081:8080 kotlin-inno-native`

## JVM Container

Build container:
`docker build -t kotlin-inno-jvm -f Dockerfile-jvm .`

Run container:
`docker run -p 8082:8080 kotlin-inno-jvm`