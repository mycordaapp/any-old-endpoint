package mycorda.app.aoe.server.sockets

import mycorda.app.aoe.server.Logger
import mycorda.app.aoe.server.Service
import mycorda.app.aoe.server.ServiceConfig
import java.io.PrintWriter
import java.net.ServerSocket
import kotlin.concurrent.thread


data class EchoSocketServerConfig(val name: String = "echoSocket", val port: Int = 8083) : ServiceConfig

class EchoSocketServer(
    private val logger: Logger,
    private val config: EchoSocketServerConfig = EchoSocketServerConfig()
) : Service {

    lateinit var server: ServerSocket
    lateinit var thread: Thread
    var clientCount = 0

    private fun init() {
        server = ServerSocket(config.port)

        while (true) {
            val client = server.accept()
            clientCount++
            logger.addMessage("EchoSocketServer(${config.name}) client #$clientCount - new connection from $client ")
            thread = thread() {
                val clientNumber = clientCount
                val out = PrintWriter(client.getOutputStream())

                out.write("Connected. Type `quit` to exit\n")
                out.flush()

                val _in = client.inputStream
                do {
                    val buf = ByteArray(100)
                    val bytes = _in.read(buf)

                    val data = String(buf.copyOfRange(0, bytes))
                        .replace("\r", "")
                        .replace("\n", "")

                    logger.addMessage("EchoSocketServer(${config.name}) client #$clientNumber - $data")

                    out.write(String(buf))
                    out.flush()
                    Thread.sleep(10)

                } while (data != "quit")
                client.close()
                logger.addMessage("EchoSocketServer(${config.name}) client #$clientNumber - closed connection")
            }
        }
    }

    override fun start() {
        try {
            logger.addMessage("Starting EchoSocketServer(${config.name}) on ${config.port}")
            init()
            logger.addMessage("Started EchoSocketServer(${config.name}) on ${config.port}")
        } catch (ex: Exception) {
            logger.addMessage("Failed to start EchoSocketServer(${config.name}): ${ex.message}")
            ex.printStackTrace()
        }

    }

    override fun stop() {
        logger.addMessage("Stopped EchoSocketServer(${config.name}) on ${config.port} ")
    }

}