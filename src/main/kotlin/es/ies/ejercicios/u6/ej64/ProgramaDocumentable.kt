package es.ies.ejercicios.u6.ej64

// Este fichero contiene ejemplos de:
// - herencia (6.1)
// - clase abstracta e interfaces (6.2)
// - constructores e init en herencia (6.3)
//
// Tu tarea (6.4) es:
// - Entender el código y su relación entre clases e interfaces.
// - Mejorar la documentación KDoc donde sea necesario.
// - Añadir comentarios solo cuando aporten valor.
// - Eliminar comentarios innecesarios o redundantes.

/**
 * Representa un elemento que puede generar un resumen en texto.
 */
interface Resumible {
    /**
     * Resumen
     *
     * @return texto resumen del objeto
     */
    fun resumen(): String
}

/**
 * Plantilla para generar un informe en distintos formatos.
 *
 * Nota: el método [generar] está bloqueado (no es `open`) para forzar un flujo común
 * y permitir que las subclases solo personalicen las partes variables.
 */
abstract class PlantillaInforme : Resumible {
    /**
     * Generar genera el informe a partir de l título y una lista de elementos resumibles
     *
     * @param titulo titulo del informe
     * @param items elementos que se incluyen en el informe
     * @return devuelve el informe en forma de texto
     */
    fun generar(titulo: String, items: List<Resumible>): String {
        val sb = StringBuilder()

        sb.appendLine(cabecera(titulo))

        for (item in items) {
            sb.appendLine(formatearItem(item))
        }

        sb.appendLine(pie())
        return sb.toString()
    }

    /**
     * Cabecera
     *
     * @param titulo titulo del informe
     * @return devuelve la cabecera en texto
     */
    protected open fun cabecera(titulo: String): String = titulo

    /**
     * Formatear item
     *
     * @param item item resumible del informe
     * @return devuelve el item formateado en texto
     */
    protected abstract fun formatearItem(item: Resumible): String

    /**
     * Pie
     *
     * @return devuelve el string "-- fin --"
     */
    protected open fun pie(): String = "-- fin --"

    /**
     * Resumen
     *
     * @return devuelve el string "PlantillaInforme"
     */
    override fun resumen(): String = "PlantillaInforme"
}

/**
 * Informe Markdown: implementa un informe en formato Markdown.
 */
class InformeMarkdown : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "# $titulo"

    override fun formatearItem(item: Resumible): String = "- ${item.resumen()}"
}

/**
 * Informe csv: implementa un informe en formato csv.
 *
 * Descripcion: Se reemplazan las comas internas por punto y coma.
 */
class InformeCsv : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "titulo,$titulo\nitem"

    override fun formatearItem(item: Resumible): String = item.resumen().replace(",", ";")
}

/**
 * Persona
 *
 * @property nombre nombre de la persona
 * @property edad edad de la persona
 */
open class Persona(
    val nombre: String,
    val edad: Int,
) : Resumible {
    init {
        println("[Persona:init] nombre=$nombre edad=$edad")
    }

    /**
     * Constructor secundario que crea una persona con:
     * @param nombre
     * Por defecto la edad es 0
     */
    constructor(nombre: String) : this(nombre, edad = 0) {
        println("[Persona:secondary] constructor(nombre)")
    }
    override fun resumen(): String = "$nombre ($edad)"
}

/**
 * Alumno
 * @property curso curso del alumno
 */
class Alumno : Persona {
    val curso: String

    /**
     * Constructor secundario que crea un objeto alumno con:
     * @param nombre
     * @param edad
     * @param curso
     */
    constructor(nombre: String, edad: Int, curso: String) : super(nombre, edad) {
        // Asignar curso
        this.curso = curso
        println("[Alumno:secondary] nombre=$nombre edad=$edad curso=$curso")
    }

    /**
     * Constructor secundario que crea un objeto alumno con:
     * @param nombre
     * @param curso
     * Edad predeterminada es 0
     */
    constructor(nombre: String, curso: String) : this(nombre, edad = 0, curso = curso) {
        println("[Alumno:secondary] constructor(nombre, curso)")
    }

    override fun resumen(): String = "Alumno: ${super.resumen()} curso=$curso"
}

/**
 * Registro personas
 * La normalización evita duplicados o fallos en la búsqueda
 */
class RegistroPersonas {
    private val personasPorNombre = mutableMapOf<String, Persona>()

    fun registrar(persona: Persona) {
        val clave = normalizarNombre(persona.nombre)
        personasPorNombre[clave] = persona
    }

    /**
     * Buscar
     *
     * @param nombre nombre de la persona
     * @return devuelve el nombre normalizado (sin espacios en blanco y en minúsculas)
     */
    fun buscar(nombre: String): Persona? = personasPorNombre[normalizarNombre(nombre)]

    private fun normalizarNombre(nombre: String): String {
        return nombre.trim().lowercase()
    }
}
