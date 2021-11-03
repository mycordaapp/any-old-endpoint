package mycorda.app.aoe.server;

import mycorda.app.aoe.server.http.AdminServer
import mycorda.app.aoe.server.http.HttpServer

fun main(args: Array<String>) {
    val services = ArrayList<Service>()
    val logger = Logger()

    services.add(AdminServer(logger))
    services.add(HttpServer(logger))

    services.forEach {it.start()}

}