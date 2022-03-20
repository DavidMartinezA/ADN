package com.example.domain.entity

import org.junit.Test

class CarroTest {

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrecto_NumeroPlacaNoVacio() {
        val carroTestNumeroPlaca = Carro("HSU531")
        val numeroPlaca = carroTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca.isNotEmpty())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaVacio_NumeroPlacaVacio() {
        val carroTestNumeroPlaca = Carro("")
        val numeroPlaca = carroTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca.isEmpty())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrectoMayusculas_NumeroPlacaMayusculas() {
        val carroTestNumeroPlaca = Carro("HSU531")
        val numeroPlaca = carroTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca == numeroPlaca.uppercase())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrectoMinusculas_NumeroPlacaMayusculas() {
        val carroTestNumeroPlaca = Carro("hsu531")
        val numeroPlaca = carroTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca == numeroPlaca.uppercase())
    }


}