package es.ies.ejercicios.u6.ej61.especializacion

fun main(){
    // Asignamos a una variable de la superclase una instancia de cada subclase: Conejo y Tiburon
    var animal1: Animal = Conejo(patas = 4, peso = 5.5)
    var animal2: Animal = Tiburon(patas = 0, peso = 150.0)

    animal1.hacerRuido()
    animal1.caminar()

    animal2.hacerRuido()
    animal2.caminar()
}