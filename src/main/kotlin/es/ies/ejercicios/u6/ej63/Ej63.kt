package es.ies.ejercicios.u6.ej63

/**
 * Ejercicio 6.3 — Incidencia de constructores en la herencia (RA7.c).
 *
 * Punto de partida: revisa `Figuras.kt` y completa lo indicado en `docs/ejercicios/6.3.md`.
 */
object Ej63

fun main() {
    println("Ejercicio 6.3 (plantilla)")
    println("- Completa la jerarquía y los constructores en `es.ies.ejercicios.u6.ej63`")
    println("- Añade logs en init/constructores para ver el orden de inicialización")
    println("- Actualiza este main para instanciar usando distintos constructores")

    val figura1 = Figura("Rojo", "figura")
    val figura2 = Figura("Rojo")

    val rectangulo1 = Rectangulo("Azul", "rectangulo", 10, 15)
    val rectangulo2 = Rectangulo(10, 15)
    val rectangulo3 = Rectangulo(10)

    val circulo1 = Circulo("Verde", "circulo", 10)
    val circulo2 = Circulo(10)

    val triangulo1 = Triangulo(10, 15)
    val triangulo2 = Triangulo(10)
}
