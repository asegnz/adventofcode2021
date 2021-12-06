package com.asegnz.adventofcode2021

import java.io.File

internal class Day3 {

    companion object {
        fun process(filename: String) : Int {
            val array = initializeArray(filename)
            File(filename).forEachLine {
                for ((index, value) in it.withIndex()) {
                    if (value.toString().equals("1")) {
                        array[index] += 1
                    }
                    else {
                        array[index] -= 1
                    }
                }
            }
            println("Array is ${array.toList()}")
            val gamma: String = extractGamma(array)
            val epsilon: String = extractEpsilon(array)
            return base10(gamma) * base10(epsilon)
        }


        internal fun base10(binaryString: String): Int {
            return Integer.parseInt(binaryString,2)
        }

        private fun extractGamma(array: IntArray): String {
            var gamma = ""
            array.forEach {
                if (it > 0 ) {
                    gamma += "1"
                }
                else {
                    gamma += "0"
                }
            }
            println("Gamma is $gamma")
            return gamma
        }

        private fun extractEpsilon(array: IntArray): String {
            var epsilon = ""
            array.forEach {
                if (it < 0 ) {
                    epsilon += "1"
                }
                else {
                    epsilon += "0"
                }
            }
            println("Epsilon is $epsilon")
            return epsilon
        }

        private fun initializeArray(filename: String): IntArray {
            var array = IntArray(1) { 0 }
            File(filename).forEachLine {
                array = IntArray(it.trim().length) { 0 }
            }
            return array
        }
    }

}
