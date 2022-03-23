package com.example.domain.entidad

import org.junit.Test

class CarroTest {

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrecto_NumeroPlacaNoVacio() {
        val carroTestNumeroPlaca = Carro("HSU531")
        val numeroPlaca = carroTestNumeroPlaca.identificacionVehiculo

        assert(numeroPlaca.isNotEmpty())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaVacio_NumeroPlacaVacio() {
        val carroTestNumeroPlaca = Carro("")
        val numeroPlaca = carroTestNumeroPlaca.identificacionVehiculo

        assert(numeroPlaca.isEmpty())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrectoMayusculas_NumeroPlacaMayusculas() {
        val carroTestNumeroPlaca = Carro("HSU531")
        val numeroPlaca = carroTestNumeroPlaca.identificacionVehiculo

        assert(numeroPlaca == numeroPlaca.uppercase())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrectoMinusculas_NumeroPlacaMayusculas() {
        val carroTestNumeroPlaca = Carro("hsu531")
        val numeroPlaca = carroTestNumeroPlaca.identificacionVehiculo

        assert(numeroPlaca == numeroPlaca.uppercase())
    }


}