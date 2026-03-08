package es.ies.ejercicios.u6.ej62

class MarkdownReport(private val logger: Logger) : ReportTemplate(logger) {
    // Personaliza el header convirtiendo el texto en formato Markdown
    override fun header(title: String): String = "# $title\n\n"

    // Transforma cada línea
    override fun formatLine(linea: String): String {
        logger.log("Markdown: '$linea'")
        return " $linea"
    }
}
