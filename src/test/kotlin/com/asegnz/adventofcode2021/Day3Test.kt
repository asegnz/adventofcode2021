package com.asegnz.adventofcode2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day3Test {

    @Test
    fun example1() {
        val resultado = Day3.process("src/main/resources/day3/example.txt")
        assertEquals(198, resultado)
    }

    @Test
    fun exam1() {
        val resultado = Day3.process("src/main/resources/day3/exam.txt")
        println("Exam 1 result is $resultado")
    }

    @Test
    fun binaryTest() {
        val expected = 16
        val actual = Day3.base10("10000")
        assertEquals(expected, actual)
    }

}