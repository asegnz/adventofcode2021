package com.asegnz.adventofcode2021.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day3Test {

    @Test
    fun example1() {
        val resultado = Day3.processPart1("src/main/resources/day3/example.txt")
        assertEquals(198, resultado)
    }

    @Test
    fun exam1() {
        val resultado = Day3.processPart1("src/main/resources/day3/exam.txt")
        println("Exam 1 result is $resultado")
    }

    @Test
    fun example2() {
        val resultado = Day3.processPart2("src/main/resources/day3/example.txt")
        assertEquals(230, resultado)
    }

    @Test
    fun exam2() {
        val resultado = Day3.processPart2("src/main/resources/day3/exam.txt")
        println("Exam 2 result is $resultado")
    }

    @Test
    fun binaryTest() {
        val expected = 16
        val actual = Day3.base10("10000")
        assertEquals(expected, actual)
    }

}