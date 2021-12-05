package com.asegnz.adventofcode2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day1Test {
    @Test
    fun example() {
        val incrementos = Day1.calculaMayores("src/main/resources/day1/example.txt")
        Assertions.assertEquals(7, incrementos)
    }

    @Test
    fun calculaIncrementos() {
        val incrementos = Day1.calculaMayores("src/main/resources/day1/exam.txt")
        println(incrementos)
    }

    @Test
    fun ventanas() {
        val incrementos = Day1.calculaVentana3("src/main/resources/day1/exam.txt")
        println("Los incrementos son $incrementos")
    }
}