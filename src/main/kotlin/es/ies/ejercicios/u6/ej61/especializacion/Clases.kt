package es.ies.ejercicios.u6.ej61.especializacion
/* ESPECIALIZACIÓN */

open class Animal(var patas: Int, var peso: Double){
    open fun hacerRuido(){
        println("Hacer ruido")
    }
    open fun caminar(){
        println("Caminar")
    }
}

class Conejo(patas: Int, peso: Double) : Animal(patas, peso) {
    override fun hacerRuido(){
        println("Conejo hace ruido")
    }
    override fun caminar() {
        println("Conejo camina")
    }
    fun darSaltitos(){
        println("Conejo da saltitos")
    }
}
class Tiburon(patas: Int, peso: Double) : Animal(patas, peso) {
    override fun hacerRuido(){
        println("Tiburón hace ruido")
    }
    override fun caminar() {
        println("Tiburón camina")
    }
    fun comerPez(){
        println("Tiburón se come un pez")
    }

}



