package mycorda.app.aoe.server.http

import mycorda.app.aoe.server.Logger
import mycorda.app.aoe.server.Service
import org.http4k.server.*


data class AdminServerConfig(val name: String = "adminServer", val port: Int = 8080)

class AdminServer(
    private val logger: Logger,
    private val config: AdminServerConfig = AdminServerConfig()
) : Service {
    private lateinit var server: Http4kServer

    init {
        try {
            AdminControllers(logger).asServer(Jetty(config.port)).also { server = it }
        } catch (ex: Exception) {
            logger.addMessage("Failed to register AdminServer(${config.name}): ${ex.message}")
            ex.printStackTrace()
        }
    }

    override fun start() {
        try {
            logger.addMessage("Starting AdminServer(${config.name}) on ${config.port} ")
            server.start()
            logger.addMessage("Started AdminServer(${config.name}) on ${config.port} ")
        } catch (ex: Exception) {
            logger.addMessage("Failed to start AdminServer(${config.name}): ${ex.message}")
            ex.printStackTrace()
        }
    }

    override fun stop() {
        try {
            logger.addMessage("Stopping AdminServer(${config.name}) on ${config.port} ")
            server.start()
            logger.addMessage("Stopped AdminServer(${config.name}) on ${config.port} ")
        } catch (ex: Exception) {
            logger.addMessage("Failed to stop AdminServer(${config.name}): ${ex.message}")
            ex.printStackTrace()
        }
    }
}