package com.asegnz.adventofcode2021.day7

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day7Test {
    @Test
    fun example1Part1() {
        val combustible = Day7.usoCombustible(2, "src/main/resources/day7/example.txt", true, false)
        assertEquals(37, combustible)
    }

    @Test
    fun example2Part1() {
        val combustible = Day7.usoCombustible(1, "src/main/resources/day7/example.txt", true, false)
        assertEquals(41, combustible)
    }

    @Test
    fun example3Part1() {
        val combustible = Day7.usoCombustible(10, "src/main/resources/day7/example.txt", true, false)
        assertEquals(71, combustible)
    }

    @Test
    fun examPart1() {
        val combustible = Day7.usoCombustible(328, "src/main/resources/day7/exam.txt", true, false)
        println("Combustible is $combustible")
    }

    @Test
    fun example1Part2() {
        val combustible = Day7.usoCombustible(2, "src/main/resources/day7/example.txt", false, false)
        assertEquals(206, combustible)
    }

    @Test
    fun example2Part2() {
        val combustible = Day7.usoCombustible(5, "src/main/resources/day7/example.txt", false, false)
        assertEquals(168, combustible)
    }

    @Test
    fun examPart2() {
        val combustible = Day7.usoCombustible(328, "src/main/resources/day7/exam.txt", false, true)
        println("Combustible is $combustible")
    }
}