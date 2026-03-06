package es.ies.ejercicios.u6.ej61.extension

/* EXTENSION */
open class Persona(var nombre: String, var id: Int)

class Estudiante(nombre: String, id: Int, val curso: Int) : Persona(nombre, id){
    fun estudiar(){
        println("Estudiante está estudiando")
    }
}
class Obrero(nombre: String, id: Int) : Persona(nombre, id){
    fun construir(){
        println("Obrero construye")
    }
}
