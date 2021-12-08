package com.asegnz.adventofcode2021.day5

import java.io.File

class Day5 {

    internal class CoordenadaMagica (x: Int, y: Int) : Coordenada(x, y) {
        @Override
        internal fun vector(otraCoordenada: CoordenadaMagica) : List<Coordenada> {
            val coordenadas = mutableListOf<Coordenada>()
            val ortogonal = validarOrtogonalidad(this, otraCoordenada)
            if (!ortogonal) {
                val diagonal = validarDiagonal(this, otraCoordenada)
                if (!diagonal) {
                    return emptyList()
                }
                else {
                    vectorDiagonal(otraCoordenada, coordenadas)
                }
            }
            else {
                vectorOrtogonal(otraCoordenada, coordenadas)
            }
            return coordenadas
        }

        private fun vectorDiagonal(otraCoordenada: CoordenadaMagica, coordenadas: MutableList<Coordenada>) {
            val xs = arrayListOf(x, otraCoordenada.x)
            val ys = arrayListOf(y, otraCoordenada.y)
            fill(xs)
            fill(ys)
            for (i in 0..xs.size-1) {
                coordenadas.add(Coordenada(xs.get(i), ys.get(i)))
            }
        }

        private fun fill(arraylist: ArrayList<Int>) {
            // 1 -> 5
            if (arraylist.first() < arraylist.last()) {
                for (i in arraylist.last()-1 downTo arraylist.first()+1){
                    arraylist.add(1, i)
                }
            } // 5 -> 1
            else if (arraylist.first() > arraylist.last()) {
                for (i in arraylist.last()+1 until arraylist.first()){
                    arraylist.add(1, i)
                }
            }
        }

        private fun vectorOrtogonal(
            otraCoordenada: CoordenadaMagica,
            coordenadas: MutableList<Coordenada>
        ) {
            val rangoX = rangoX(otraCoordenada)
            val rangoY = rangoY(otraCoordenada)
            for (ix in rangoX) {
                for (jy in rangoY) {
                    coordenadas.add(Coordenada(ix, jy))
                }
            }
        }

        private fun validarDiagonal(coor1: CoordenadaMagica, coor2: CoordenadaMagica) : Boolean {
            val distanciaX = coor1.x - coor2.x
            val distanciaY = coor1.y - coor2.y
            return Math.abs(distanciaX) == Math.abs(distanciaY)
        }
    }


    internal open class Coordenada(val x: Int, val y: Int) {
        internal open fun vector(otraCoordenada: Coordenada): List<Coordenada> {
            val validated = validarOrtogonalidad(this, otraCoordenada)
            if (!validated) return emptyList()
            val coordenadas = mutableListOf<Coordenada>()
            val rangoX = rangoX(otraCoordenada)
            val rangoY = rangoY(otraCoordenada)
            for (ix in rangoX) {
                for (jy in rangoY) {
                    coordenadas.add(Coordenada(ix, jy))
                }
            }
            return coordenadas
        }

        protected fun rangoX(otraCoordenada: Coordenada): IntRange {
            if (x > otraCoordenada.x) {
                return otraCoordenada.x..x
            } else return x..otraCoordenada.x
        }

        protected fun rangoY(otraCoordenada: Coordenada): IntRange {
            if (y > otraCoordenada.y) {
                return otraCoordenada.y..y
            } else return y..otraCoordenada.y
        }

        protected fun validarOrtogonalidad(coordenada: Coordenada, otraCoordenada: Coordenada): Boolean {
            if (coordenada.y != otraCoordenada.y && coordenada.x != otraCoordenada.x) {
                println("Las coordenadas $coordenada y $otraCoordenada no son horizontales o verticales")
                return false
            }
            return true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Coordenada

            if (x != other.x) return false
            if (y != other.y) return false

            return true
        }

        override fun hashCode(): Int {
            var result = x
            result = 31 * result + y
            return result
        }

        override fun toString(): String {
            return "Coordenada(x=$x, y=$y)"
        }

    }

    companion object {
        fun puntosParte1(filename: String): Int {
            val file = File(filename)
            val pair = calculaMaximosTablero(file, 0, 0)
            val matrix = arrayListOf<IntArray>()
            initMatrix(matrix, pair.first, pair.second)
            fillMatrixPart1(file, matrix)
            return countAtLeast2(matrix)
        }

        fun puntosParte2(filename: String): Int {
            val file = File(filename)
            val pair = calculaMaximosTablero(file, 0, 0)
            val matrix = arrayListOf<IntArray>()
            initMatrix(matrix, pair.first, pair.second)
            fillMatrixPart2(file, matrix)
            return countAtLeast2(matrix)
        }

        private fun countAtLeast2(matrix: java.util.ArrayList<IntArray>): Int {
            var puntos = 0
            matrix.forEach { filas ->
                filas.forEach { contador ->
                    if (contador > 1) {
                        puntos += 1
                    }
                }
            }
            return puntos
        }

        private fun fillMatrixPart1(file: File, matrix: List<IntArray>) {
            file.forEachLine { line ->
                val parOrigenDestino = line.replace(" ", "").trim().split("->")
                val origen = parOrigenDestino[0].split(",")
                val destino = parOrigenDestino[1].split(",")
                val vector = Coordenada(origen[0].toInt(), origen[1].toInt()).vector(
                    Coordenada(destino[0].toInt(), destino[1].toInt())
                )
                vector.forEach { coordenada ->
                    matrix[coordenada.y][coordenada.x] += 1
                }
            }
        }

        private fun fillMatrixPart2(file: File, matrix: List<IntArray>) {
            file.forEachLine { line ->
                val parOrigenDestino = line.replace(" ", "").trim().split("->")
                val origen = parOrigenDestino[0].split(",")
                val destino = parOrigenDestino[1].split(",")
                val vector = CoordenadaMagica(origen[0].toInt(), origen[1].toInt()).vector(
                    CoordenadaMagica(destino[0].toInt(), destino[1].toInt())
                )
                vector.forEach { coordenada ->
                    matrix[coordenada.y][coordenada.x] += 1
                }
            }
        }

        private fun initMatrix(matrix: ArrayList<IntArray>, maxX: Int, maxY: Int) {
            for (i in 0..maxX) {
                matrix.add(IntArray(maxY + 1) { 0 })
            }
        }

        private fun calculaMaximosTablero(
            file: File,
            maxX: Int,
            maxY: Int
        ): Pair<Int, Int> {
            var maxX1 = maxX
            var maxY1 = maxY
            file.forEachLine {
                val coordenadas = it.replace(" ", "").trim().split("->")
                coordenadas.forEach {
                    val pieces = it.split(",")
                    if (maxX1 < pieces[0].toInt()) {
                        maxX1 = pieces[0].toInt()
                    }
                    if (maxY1 < pieces[1].toInt()) {
                        maxY1 = pieces[1].toInt()
                    }
                }
            }
            return Pair(maxX1, maxY1)
        }
    }
}