package com.example.s1reto1unai;

import static kotlin.io.ConsoleKt.readlnOrNull;

public class reto3 {
    /* 1. Crea un programa donde:
   Pide al usuario una contraseña y comprueba que:
   - Tiene al menos ocho caracteres.
   - Contiene una mayúscula.
   - Contiene una minúscula.
   - Contiene un número.
   - No contiene espacios.
   El programa debe indicar todos los requisitos que incumple. */
    fun main() {
        print("Introduce una contraseña: ")
        val password = readlnOrNull() ?: ""

        val errores = mutableListOf<String>()

        // 1. Comprobar longitud
        if (password.length < 8) {
            errores.add("Falta tener al menos 8 caracteres.")
        }

        // 2. Comprobar mayúscula, minúscula y número recorriendo con un bucle for
        var tieneMayuscula = false
        var tieneMinuscula = false
        var tieneNumero = false

        for (caracter in password) {
            if (caracter.isUpperCase()) tieneMayuscula = true
            if (caracter.isLowerCase()) tieneMinuscula = true
            if (caracter.isDigit()) tieneNumero = true
        }

        if (!tieneMayuscula) {
            errores.add("Falta una letra mayúscula.")
        }
        if (!tieneMinuscula) {
            errores.add("Falta una letra minúscula.")
        }
        if (!tieneNumero) {
            errores.add("Falta un número.")
        }

        // 3. Comprobar espacios usando el operador 'in'
        if (' ' in password) {
            errores.add("No debe contener espacios.")
        }

        // Resultado final
        if (errores.isEmpty()) {
            println("¡Contraseña válida!")
        } else {
            print("Contraseña no válida:")
            for (error in errores) {
                print(" - $error")
            }
            println()
        }
    }


/* 2. El usuario introduce temperaturas hasta escribir fin.
   El programa debe mostrar:
   - La temperatura máxima.
   - La mínima.
   - La media.
   - Cuántas temperaturas están por encima de la media.
   - La diferencia máxima entre dos temperaturas consecutivas.
   - Si la temperatura subió, bajó o se mantuvo entre cada medición. */
/*fun main() {
    val temperaturas = mutableListOf<Double>()

    println("Introduce temperaturas (escribe 'fin' para terminar):")
    while (true) {
        val entrada = readlnOrNull()
        if (entrada == null || entrada.lowercase() == "fin") {
            break
        }
        val temp = entrada.toDoubleOrNull()
        if (temp != null) {
            temperaturas.add(temp)
        } else {
            println("Por favor, introduce un número válido o 'fin'.")
        }
    }

    if (temperaturas.isEmpty()) {
        println("No se han introducido temperaturas.")
        return
    }

    // 1. Máxima y mínima
    var maxima = temperaturas.first()
    var minima = temperaturas.first()
    for (t in temperaturas) {
        if (t > maxima) maxima = t
        if (t < minima) minima = t
    }

    // 2. Media
    var suma = 0.0
    for (t in temperaturas) {
        suma += t
    }
    val media = suma / temperaturas.count()

    // 3. Por encima de la media
    var porEncima = 0
    for (t in temperaturas) {
        if (t > media) {
            porEncima++
        }
    }

    // 4. Variación máxima consecutiva y evolución (subió/bajó/mantuvo)
    var maxVariacion = 0.0
    for (i in 0 until temperaturas.count() - 1) {
        val actual = temperaturas[i]
        val siguiente = temperaturas[i + 1]

        val diferencia = siguiente - actual
        val diferenciaAbsoluta = if (diferencia < 0) -diferencia else diferencia

        if (diferenciaAbsoluta > maxVariacion) {
            maxVariacion = diferenciaAbsoluta
        }

        val estado = when {
            siguiente > actual -> "subió"
            siguiente < actual -> "bajó"
            else -> "se mantuvo"
        }
        println("Entre la medición ${i+1} y ${i+2} ($actual a $siguiente): la temperatura $estado.")
    }

    // Mostrar resumen final
    println("\n--- RESUMEN ---")
    println("Máxima: $maxima")
    println("Mínima: $minima")
    println("Media: $media")
    println("Por encima de la media: $porEncima")
    println("Mayor variación consecutiva: $maxVariacion")
}*/


/* 3. Crea una variable llamada correo que pueda contener un String o null.
   Usa ?.let para mostrar el siguiente mensaje únicamente cuando el correo no sea null:
   "Enviando mensaje a alumno@correo.com". Si el correo es nulo imprime:
   "No se ha indicado ningún correo" */
/*fun main() {
    val correo: String? = "alumno@correo.com"
    // O prueba con: val correo: String? = null

    correo?.let {
        println("Enviando mensaje a $it")
    } ?: println("No se ha indicado ningún correo")
}*/
}
