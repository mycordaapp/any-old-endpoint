package mycorda.app.aoe.server

class Logger {
    private val messages = ArrayList<String>()

    fun addMessage(msg: String): Logger {
        messages.add(msg)
        println(msg)    // echo to console for quick feedback
        return this
    }

    fun messages(): Iterable<String> = this.messages
}