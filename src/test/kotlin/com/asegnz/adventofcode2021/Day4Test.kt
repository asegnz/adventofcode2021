package com.asegnz.adventofcode2021

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day4Test {

    @Test
    fun crearSerieExample() {
        val serie = Day4.crearSerie("src/main/resources/day4/example_serie.txt")
        assertEquals(7, serie.first())
        assertEquals(1, serie.last())
    }

    @Test
    fun crearCartonesExample() {
        // 22 el primero, 7 el último
        val cartones = Day4.crearCartones("src/main/resources/day4/example_cartones.txt")
        assertEquals(3, cartones.size)
        assertEquals(22, cartones.iterator().next().celdas.get(0).get(0))
        assertEquals(7, cartones.get(2).celdas.get(4).get(4))
    }

    @Test
    fun calculaCartonVencedorLinea() {
        val carton = Day4.calculaVencedorLinea("src/main/resources/day4/example_serie.txt", "src/main/resources/day4/example_cartones.txt")
        assertEquals(2, carton.posicion)
    }

    @Test
    fun calculaPuntosParte1Example() {
        val carton = Day4.calculaVencedorLinea("src/main/resources/day4/example_serie.txt", "src/main/resources/day4/example_cartones.txt")
        val puntos = Day4.calculaPuntosParte1(carton, 24)
        assertEquals(4512, puntos)
    }

    @Test
    fun calculaPuntosParte1Exam() {
        val carton = Day4.calculaVencedorLinea("src/main/resources/day4/exam_serie.txt", "src/main/resources/day4/exam_cartones.txt")
        val puntos = Day4.calculaPuntosParte1(carton, 21)
        println("Exam part1 is $puntos")
    }

    @Test
    fun calculaPuntosParte2Example() {
        val carton = Day4.calculaUltimoVencedor("src/main/resources/day4/example_serie.txt", "src/main/resources/day4/example_cartones.txt")
        val puntos = Day4.calculaPuntosParte1(carton, 13)
        println("Example part2 is $puntos")
    }

    @Test
    fun calculaPuntosParte2Exam() {
        val carton = Day4.calculaUltimoVencedor("src/main/resources/day4/exam_serie.txt", "src/main/resources/day4/exam_cartones.txt")
        val puntos = Day4.calculaPuntosParte1(carton, 40)
        println("Exam part2 is $puntos")
    }
}