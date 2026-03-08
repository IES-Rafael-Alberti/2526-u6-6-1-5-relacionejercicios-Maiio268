package es.ies.ejercicios.u6.ej62

class CsvReport(private val logger: Logger) : ReportTemplate(logger) {
    override fun formatLine(linea: String): String {
        logger.log("CSV: '$linea'")
        return linea
    }
    override fun header(title: String): String = "title,$title\nlinea\n"
}