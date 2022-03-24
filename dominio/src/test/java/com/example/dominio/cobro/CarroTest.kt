package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Carro
import org.junit.Test

class CarroTest {

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrecto_NumeroPlacaNoVacio() {
        val carroTestNumeroPlaca = Carro("HSU531")
        val numeroPlaca = carroTestNumeroPlaca.placaVehiculo

        assert(numeroPlaca.isNotEmpty())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaVacio_NumeroPlacaVacio() {
        val carroTestNumeroPlaca = Carro("")
        val numeroPlaca = carroTestNumeroPlaca.placaVehiculo

        assert(numeroPlaca.isEmpty())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrectoMayusculas_NumeroPlacaMayusculas() {
        val carroTestNumeroPlaca = Carro("HSU531")
        val numeroPlaca = carroTestNumeroPlaca.placaVehiculo

        assert(numeroPlaca == numeroPlaca.uppercase())
    }

}