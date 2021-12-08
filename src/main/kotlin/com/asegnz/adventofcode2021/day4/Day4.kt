package com.asegnz.adventofcode2021.day4

import java.io.File

internal class Day4 {

    internal class Carton(val posicion: Int) {
        var celdas = arrayListOf<IntArray>()
        var tachados = arrayListOf<BooleanArray>()

        internal fun addRow(array: IntArray) {
            celdas.add(array)
            tachados.add(array.map { number -> false }.toBooleanArray())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Carton

            if (celdas != other.celdas) return false
            if (tachados != other.tachados) return false

            return true
        }

        override fun hashCode(): Int {
            var result = celdas.hashCode()
            result = 31 * result + tachados.hashCode()
            return result
        }

        override fun toString(): String {
            return "Carton(celdas=$celdas, tachados=$tachados)"
        }


    }

    companion object {
        internal fun crearSerie(filename: String): List<Int> {
            val list = mutableListOf<Int>()
            File(filename).forEachLine {
                val pieces = it.split(",")
                pieces.forEach { piece -> list.add(piece.toInt()) }
            }
            return list
        }

        internal fun crearCartones(filename: String): List<Carton> {
            val lista = mutableListOf<Carton>()
            var posicion = 0
            var carton = Carton(posicion)
            File(filename).forEachLine {
                if (it.trim().equals("")) {
                    lista.add(carton)
                    posicion++
                    carton = Carton(posicion)
                } else {
                    var withoutFirstSpace = it
                    if (it.substring(0, 1).equals(" ")) {
                        withoutFirstSpace = it.replaceFirst(" ", "")
                    }
                    val oneSpaceLine = withoutFirstSpace.replace("  ", " ")
                    val pieces = oneSpaceLine.split(" ")
                    carton.addRow(pieces.map { piece -> piece.toInt() }.toIntArray())
                }
            }
            return lista
        }

        internal fun calculaVencedorLinea(serieFileName: String, cartonesFileName: String): Carton {
            val serie = crearSerie(serieFileName)
            val cartones = crearCartones(cartonesFileName)
            serie.forEach() {
                tacha(it, cartones)
                val lista = buscarLinea(cartones)
                if (lista.size > 0) {
                    val vencedor: Carton = buscarLinea(cartones).get(0)
                    println("Se devuelve vencedor tras el número $it")
                    return vencedor
                }
            }
            return Carton(0)
        }

        internal fun calculaUltimoVencedor(serieFileName: String, cartonesFileName: String): Carton {
            val serie = crearSerie(serieFileName)
            val cartones = crearCartones(cartonesFileName).toMutableList()
            var ultimoVencedor: Carton? = null
            var numero: Int
            serie.forEach {
                numero = it
                tacha(numero, cartones)
                val vencedores: List<Carton> = buscarLinea(cartones)
                if (vencedores.isNotEmpty()) {
                    vencedores.forEach {
                        println("Se encuentra vencedor en la posicion ${it.posicion} tras el número $numero")
                        ultimoVencedor = it
                        cartones.remove(it)
                    }
                    println("Nos quedan ${cartones.size} cartones...")
                }
            }
            println("Se devuelve el ultimo vencedor en la posicion ${ultimoVencedor!!.posicion}")
            return ultimoVencedor!!
        }

        private fun buscarLinea(cartones: List<Carton>): List<Carton> {
            val vencedores = mutableListOf<Carton>()
            cartones.forEach() {
                // buscar filas
                for (i in 0..it.tachados.size - 1) {
                    var linea = true
                    for (j in 0..it.tachados.get(i).size - 1) {
                        if (it.tachados.get(i)[j] == false) {
                            linea = false
                            break
                        }
                    }
                    if (linea) {
                        println("Din din din din, tenemos linea en el carton numero ${it.posicion} con la linea ${it.celdas[i].toList()}")
                        vencedores.add(it)
                        break
                    }
                }
                // buscar columnas
                for (j in 0..it.tachados.size - 1) {
                    var linea = true
                    for (i in 0..it.tachados.size - 1) {
                        if (it.tachados.get(i)[j] == false) {
                            linea = false
                            break
                        }
                    }
                    if (linea) {
                        println("Din din din din, tenemos COLUMNA en el carton numero ${it.posicion}")
                        vencedores.add(it)
                        break
                    }
                }
            }
            return vencedores
        }

        private fun tacha(numero: Int, cartones: List<Carton>) {
            cartones.forEach() {
                for (i in 0..it.celdas.size - 1) {
                    for (j in 0..it.celdas.get(i).size - 1) {
                        if (it.celdas.get(i)[j] == numero) {
                            it.tachados.get(i)[j] = true
                        }
                    }
                }
            }
        }

        fun calculaPuntosParte1(carton: Carton, numero: Int): Int {
            var contador = 0
            for (i in 0..carton.tachados.size - 1) {
                for (j in 0..carton.tachados.get(i).size - 1) {
                    if (carton.tachados.get(i)[j] == false) {
                        contador += carton.celdas[i][j]
                    }
                }
            }
            return contador * numero
        }
    }
}