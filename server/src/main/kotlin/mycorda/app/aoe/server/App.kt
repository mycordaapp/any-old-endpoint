package mycorda.app.aoe.server;

import mycorda.app.aoe.server.http.AdminServer
import mycorda.app.aoe.server.http.AdminServerConfig
import mycorda.app.aoe.server.http.HttpServer
import mycorda.app.aoe.server.http.HttpServerConfig
import java.lang.RuntimeException

fun main(args: Array<String>) {
    // todo - should be comming from some little yaml file
    val configs = listOf(AdminServerConfig(), HttpServerConfig())

    val services = ArrayList<Service>()
    val logger = Logger()

    configs.forEach { config ->
        when (config) {
            is AdminServerConfig -> services.add(AdminServer(logger, config))
            is HttpServerConfig -> services.add(HttpServer(logger, config))
            else -> {
                throw RuntimeException("Dont know about config ${config::class.qualifiedName}")
            }
        }
    }

    services.forEach { it.start() }

}