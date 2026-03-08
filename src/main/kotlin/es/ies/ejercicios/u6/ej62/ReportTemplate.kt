package es.ies.ejercicios.u6.ej62

/**
 * Plantilla (para el alumnado): usa clase abstracta + "Template Method".
 *
 * Objetivo didáctico:
 * - Forzar herencia/implementación: `abstract` + miembro `abstract`.
 * - Bloquear sobrescritura del algoritmo: método `final` (o no-`open`).
 */
abstract class ReportTemplate(private val logger: Logger) {
    fun generate(title: String, lines: List<String>): String {
        logger.log("Generando $title")
        val header = header(title)
        val body = buildString {
            for (i in lines.indices) {
                if (i > 0) append("\n")
                append(formatLine(lines[i]))
            }
        }
        val footer = footer()
        val datosReporte = "$header$body$footer"
        logger.log("$title generado correctamente")
        return datosReporte
    }

    protected abstract fun formatLine(linea: String): String
    protected open fun header(title: String): String = ""
    protected open fun footer(): String = "\n--- Fin del reporte ---\n"
}