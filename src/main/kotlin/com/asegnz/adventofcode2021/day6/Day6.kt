package com.asegnz.adventofcode2021.day6

import java.io.File

internal class Day6 {
    internal class BancoPeces {
        val peces: LongArray = LongArray(9)
        fun pasarDia() {
            val reproductores = peces[0]
            for (i in 0..peces.size-2) {
                peces[i] = peces[i+1]
            }
            // reproducciones
            peces[8] = reproductores
            peces[6] += reproductores
        }
        fun anyadePez(index: Int) {
            peces[index] = peces[index]+1
        }
    }

    companion object {
        fun tiempoAlgoritmo2(dias: Int, filename: String): Long {
            var diasProcesados = 0
            val secuencia = arrayListOf<Byte>()
            secuenciaInicial(filename, secuencia)
            val bancoPeces = BancoPeces()
            secuencia.forEach {
                bancoPeces.anyadePez(it.toInt())
            }
            while (diasProcesados < dias) {
                bancoPeces.pasarDia()
                diasProcesados++
                println("Fin del día $diasProcesados, tenemos ${bancoPeces.peces.sum()} peces linterna")
            }
            return bancoPeces.peces.sum()
        }

        fun tiempoAlgoritmo1(dias: Int, filename: String): Pair<Int, String> {
            var diasProcesados = 0
            val secuencia = arrayListOf<Byte>()
            secuenciaInicial(filename, secuencia)
            while (diasProcesados < dias) {
                pasaTiempo(secuencia)
                diasProcesados++
                println("Fin del día $diasProcesados, tenemos ${secuencia.size} peces linterna")
            }
            return Pair(secuencia.size, imprime(secuencia))
        }

        private fun pasaTiempo(secuencia: ArrayList<Byte>) {
            var pecesNuevos = 0
            val auxList = arrayListOf<Byte>()
            secuencia.forEach { byte ->
                var restado = byte
                restado--
                auxList.add(restado)
            }
            secuencia.clear()
            auxList.forEach {
                val menosUno: Byte = -1
                if (it.equals(menosUno)) {
                    secuencia.add(6)
                    pecesNuevos++
                }
                else {
                    secuencia.add(it)
                }
            }
            for (i in 1..pecesNuevos) {
                secuencia.add(8)
            }
        }

        private fun imprime(secuencia: List<Byte>): String {
            val builder = StringBuilder().append(secuencia.get(0))
            secuencia.subList(1, secuencia.size).forEach {
                builder.append(",$it")
            }
            return builder.toString()
        }

        private fun secuenciaInicial(filename: String, secuencia: MutableList<Byte>) {
            File(filename).forEachLine { linea ->
                val pieces = linea.split(",")
                pieces.map { secuencia.add(it.toByte()) }
            }
        }

    }
}