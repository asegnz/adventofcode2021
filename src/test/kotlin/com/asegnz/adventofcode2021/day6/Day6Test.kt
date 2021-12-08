package com.asegnz.adventofcode2021.day6

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day6Test {
    @Test
    fun example1Part1() {
        val par: Pair<Int, String> = Day6.tiempoAlgoritmo1(18, "src/main/resources/day6/example.txt")
        assertEquals(26, par.first)
    }

    @Test
    fun example2Part1() {
        val par: Pair<Int, String> = Day6.tiempoAlgoritmo1(80, "src/main/resources/day6/example.txt")
        assertEquals(5934, par.first)
    }

    @Test
    fun examPart1() {
        val par: Pair<Int, String> = Day6.tiempoAlgoritmo1(80, "src/main/resources/day6/exam.txt")
        println("Exam is ${par.first}")
    }

    @Test
    fun example1Algoritmo2() {
        val peces = Day6.tiempoAlgoritmo2(18, "src/main/resources/day6/example.txt")
        assertEquals(26, peces)
    }
    @Test
    fun example2Algoritmo2() {
        val peces = Day6.tiempoAlgoritmo2(80, "src/main/resources/day6/example.txt")
        assertEquals(5934, peces)
    }

    @Test
    fun examPart1Algoritmo2() {
        val peces = Day6.tiempoAlgoritmo2(80, "src/main/resources/day6/exam.txt")
        assertEquals(387413, peces)
    }

    @Test
    fun examPart2() {
        val peces = Day6.tiempoAlgoritmo2(256, "src/main/resources/day6/exam.txt")
        println("Exam is $peces")
    }
}