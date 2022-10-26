import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun createServer(): ApplicationEngine {
    return embeddedServer(CIO, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello, world!")
            }

            get("/factorial/{number}") {
                val number = call.parameters["number"]

                val result = number?.toInt()?.run { factorial(this) }
                    ?: throw IllegalArgumentException("$number is not a number.")

                call.respondText(result.toString())
            }
        }
    }.start(wait = true)
}