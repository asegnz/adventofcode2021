package com.asegnz.adventofcode2021

import java.io.File

internal class Day1 {
    companion object {
        fun calculaMayores(filename: String): Int {
            var contador = 0
            var actual = Int.MAX_VALUE
            File(filename).forEachLine {
                val number = it.toInt()
                if (number > actual) {
                    contador++
                    println(number)
                }
                actual = number
            }
            return contador
        }

        fun calculaVentana3(from: String): Int {
            var valorVentanaAnterior = Int.MAX_VALUE
            var contador = 0
            val list = mutableListOf<Int>()

            File(from).forEachLine {
                list.add(it.toInt())
            }
            var i = 0
            while (i < list.size - 2) {
                val ventanaActual = list.get(i) + list.get(i + 1) + list.get(i + 2)
                if (ventanaActual > valorVentanaAnterior) {
                    contador++
                }
                valorVentanaAnterior = ventanaActual
                i++
            }
            return contador
        }
    }
}