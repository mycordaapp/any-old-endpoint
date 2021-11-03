package mycorda.app.aoe.server.http

import mycorda.app.aoe.server.Logger
import mycorda.app.aoe.server.text

import org.http4k.core.*
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes


class Controllers(private val logger : Logger) : HttpHandler {

    private val routes: RoutingHttpHandler = routes(
        "/ping" bind Method.GET to {
            logger.addMessage("`/ping` called from ${it.source}")
            Response.text("pong")

        },
        "/echo" bind Method.POST to {
            logger.addMessage("`/echo` called from ${it.source}")
            val message = it.bodyString()
            Response.text(message)
        }
    )

    override fun invoke(p1: Request): Response = routes(p1)
}

class HttpControllers(val port :Int ) {

}