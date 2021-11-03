package mycorda.app.aoe.server.http

import mycorda.app.aoe.server.Logger
import mycorda.app.aoe.server.Service
import mycorda.app.aoe.server.ServiceConfig
import org.http4k.server.*

data class HttpServerConfig(val name: String = "httpServer", val port: Int = 8081) : ServiceConfig

class HttpServer(
    private val logger: Logger,
    private val config: HttpServerConfig = HttpServerConfig()
) : Service {
    private lateinit var server: Http4kServer

    init {
        try {
            Controllers(logger).asServer(Jetty(config.port)).also { server = it }
        }
        catch (ex : Exception){
            logger.addMessage("Failed to register HttpServer(${config.name}): ${ex.message}")
            ex.printStackTrace()
        }
    }

    override fun start() {
        try {
            logger.addMessage("Starting HttpServer(${config.name}) on ${config.port} ")
            server.start()
            logger.addMessage("Started HttpServer(${config.name}) on ${config.port} ")
        } catch (ex: Exception) {
            logger.addMessage("Failed to start HttpServer(${config.name}): ${ex.message}")
            ex.printStackTrace()
        }
    }

    override fun stop() {
        try {
            logger.addMessage("Stopping HttpServer(${config.name}) on ${config.port} ")
            server.start()
            logger.addMessage("Stopped HttpServer(${config.name}) on ${config.port} ")
        } catch (ex: Exception) {
            logger.addMessage("Failed to stop HttpServer(${config.name}): ${ex.message}")
            ex.printStackTrace()
        }
    }
}