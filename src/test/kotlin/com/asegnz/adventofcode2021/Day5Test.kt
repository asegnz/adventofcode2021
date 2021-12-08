package com.asegnz.adventofcode2021

import com.asegnz.adventofcode2021.Day5.Companion.puntosParte1
import com.asegnz.adventofcode2021.Day5.Companion.puntosParte2
import com.asegnz.adventofcode2021.Day5.Coordenada
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day5Test {

    @Test
    fun examplePart1() {
        val puntos = puntosParte1("src/main/resources/day5/example.txt")
        assertEquals(5, puntos)
    }

    @Test
    fun vectoresHorizontales() {
        val coordenada = Coordenada(0, 0)
        val coordenadas = coordenada.vector(Coordenada(3,0))
        assertEquals(coordenada, coordenadas.get(0))
        assertEquals(Coordenada(1, 0), coordenadas.get(1))
        assertEquals(Coordenada(2, 0), coordenadas.get(2))
        assertEquals(Coordenada(3, 0), coordenadas.get(3))
    }

    @Test
    fun vectoresVerticales() {
        val coordenada = Coordenada(0, 0)
        val coordenadas = coordenada.vector(Coordenada(0,3))
        assertEquals(coordenada, coordenadas.get(0))
        assertEquals(Coordenada(0, 1), coordenadas.get(1))
        assertEquals(Coordenada(0, 2), coordenadas.get(2))
        assertEquals(Coordenada(0, 3), coordenadas.get(3))
    }

    @Test
    fun examPart1() {
        val puntos = puntosParte1("src/main/resources/day5/exam.txt")
        println("Exam part1 is $puntos")
    }

    @Test
    fun examplePart2() {
        val puntos = puntosParte2("src/main/resources/day5/example.txt")
        assertEquals(12, puntos)
    }

    @Test
    fun examPart2() {
        val puntos = puntosParte2("src/main/resources/day5/exam.txt")
        println("Exam part2 is $puntos")
    }
}