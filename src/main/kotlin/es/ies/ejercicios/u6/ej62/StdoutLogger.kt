package es.ies.ejercicios.u6.ej62.logger
import es.ies.ejercicios.u6.ej62.Logger

open class BaseLogger : Logger {
    override fun log(message: String) {
    }
}
class StdoutLogger : BaseLogger() {
    final override fun log(message: String) {
        println("[LOG] $message")
    }
}