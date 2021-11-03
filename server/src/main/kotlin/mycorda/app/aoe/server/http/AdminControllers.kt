package mycorda.app.aoe.server.http

import mycorda.app.aoe.server.Logger
import mycorda.app.aoe.server.text

import org.http4k.core.*
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes


class AdminControllers(private val logger: Logger) : HttpHandler {

    private val routes: RoutingHttpHandler = routes(
        "/log" bind Method.GET to {
            Response.text(logger.messages().joinToString(separator = "\n") + "\n")
        },
    )

    override fun invoke(p1: Request): Response = routes(p1)

}