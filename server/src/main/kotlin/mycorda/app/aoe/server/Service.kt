package mycorda.app.aoe.server

interface Service {
    fun start()
    fun stop()
}
// marker interface
interface ServiceConfig {}