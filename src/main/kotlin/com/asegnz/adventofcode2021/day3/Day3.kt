package com.asegnz.adventofcode2021.day3

import java.io.File

internal class Day3 {

    companion object {
        fun processPart1(filename: String): Int {
            val array = initializeArray(filename)
            File(filename).forEachLine {
                for ((index, value) in it.withIndex()) {
                    if (value.toString() == "1") {
                        array[index] += 1
                    } else {
                        array[index] -= 1
                    }
                }
            }
            val gamma: String = extractGamma(array)
            val epsilon: String = extractEpsilon(array)
            return base10(gamma) * base10(epsilon)
        }


        internal fun base10(binaryString: String): Int {
            return Integer.parseInt(binaryString, 2)
        }

        private fun extractGamma(array: IntArray): String {
            var gamma = ""
            array.forEach {
                if (it > 0) {
                    gamma += "1"
                } else {
                    gamma += "0"
                }
            }
            return gamma
        }

        private fun extractEpsilon(array: IntArray): String {
            var epsilon = ""
            array.forEach {
                if (it < 0) {
                    epsilon += "1"
                } else {
                    epsilon += "0"
                }
            }
            return epsilon
        }

        private fun initializeArray(filename: String): IntArray {
            var wordNumber = 0
            File(filename).forEachLine {
                wordNumber = it.trim().length
            }
            return IntArray(wordNumber) { 0 }
        }

        private fun wordLength(filename: String): Int {
            var wordLength = 0
            File(filename).forEachLine {
                wordLength = it.trim().length
            }
            return wordLength
        }

        fun processPart2(filename: String): Int {
            val mostCommonRating = mutableListOf<String>() // oxygen generator rating
            val leastCommonRating = mutableListOf<String>() // co2 scrubber rating

            File(filename).forEachLine {
                mostCommonRating.add(it.trim())
                leastCommonRating.add(it.trim())
            }

            val wordLength = wordLength(filename)
            val oxygenGeneratorRating = extractNumber(mostCommonRating, true, wordLength)
            val co2ScrubberRating = extractNumber(leastCommonRating, false, wordLength)

            return oxygenGeneratorRating * co2ScrubberRating
        }

        private fun extractNumber(list: MutableList<String>, mostCommon: Boolean, wordLength: Int) : Int {
            var auxList = list.toMutableList()
            for (i in (0..wordLength-1)) {
                println("Lista al iniciar el bucle con del index $i es ${auxList} y es mostCommon: $mostCommon")
                val bit = selectBit(auxList, i, mostCommon)
                println("Bit $bit for index $i and $mostCommon")
                auxList = auxList.filter { it.get(i).toString().equals(bit) }.toMutableList()
                if (auxList.size == 1) {
                    return base10(auxList.iterator().next())
                }
                println("Lista al finalizar el bucle con del index $i es ${auxList} y es mostCommon: $mostCommon")
            }
            println("No extracted number obtained, returning -1")
            return -1
        }

        private fun selectBit(list: MutableList<String>, i: Int, mostCommon: Boolean) : String {
            var bit = ""
            var contador = 0
            list.forEach {
                if (it.get(i).toString() == "1") {
                    contador++
                } else {
                    contador--
                }
            }
            if (mostCommon) {
                if (contador >= 0) {
                    bit = "1"
                }
                else {
                    bit = "0"
                }
            }
            else if (!mostCommon) {
                if (contador >= 0) {
                    bit = "0"
                }
                else {
                    bit = "1"
                }
            }
            else {
                println("Problema al contar en el índice $i, contador es $contador")
            }
            return bit
        }
    }

}
