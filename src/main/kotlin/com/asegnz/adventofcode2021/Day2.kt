package com.asegnz.adventofcode2021

import java.io.File

internal class Day2 {
    internal open class Submarine() {
        internal var horizontal: Int
        internal var depth: Int

        init {
            horizontal = 0
            depth = 0
        }

        open fun forward(number: Int) {
            horizontal += number
        }

        open fun up(number: Int) {
            depth -= number
        }

        open fun down(number: Int) {
            depth += number
        }
    }

    internal class GreatSubmarine : Submarine() {
        internal var aim: Int
        init {
            aim = 0
        }

        override fun forward(number: Int) {
            horizontal += number
            depth += aim * number
            print()
        }


        override fun up(number: Int) {
            aim -= number
            print()
        }

        override fun down(number: Int) {
            aim += number
            print()
        }

        private fun print() {
//            println("Sumbarine has depth $depth, horizontal $horizontal, aim $aim")
        }
    }

    companion object {
        fun process(filename: String, submarine: Submarine): Int {
            File(filename).forEachLine {
                val trozos = it.split(" ")
                val accion = trozos[0]
                val numero = trozos[1]
                mueve(submarine, accion, numero)
            }
            return submarine.horizontal * submarine.depth
        }

        private fun mueve(submarino: Submarine, accion: String, numero: String) {
            when (accion) {
                "forward" -> submarino.forward(numero.toInt())
                "up" -> submarino.up(numero.toInt())
                "down" -> submarino.down(numero.toInt())
                else -> {
                    println("Accion no reconocida: $accion")
                }
            }
        }
    }
}