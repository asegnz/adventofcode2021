package com.asegnz.adventofcode2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day2Test {
    @Test
    fun example1() {
        val posicionSubmarino = Day2.process("src/main/resources/day2/example.txt", Day2.Submarine())
        Assertions.assertEquals(150, posicionSubmarino)
    }

    @Test
    fun exam1() {
        val posicionSubmarino = Day2.process("src/main/resources/day2/exam.txt", Day2.Submarine())
        println(posicionSubmarino)
    }

    @Test
    fun example2() {
        val posicionSubmarino = Day2.process("src/main/resources/day2/example.txt", Day2.GreatSubmarine())
        Assertions.assertEquals(900, posicionSubmarino)
    }

    @Test
    fun exam2() {
        val posicionSubmarino = Day2.process("src/main/resources/day2/exam.txt", Day2.GreatSubmarine())
        println(posicionSubmarino)
    }

}