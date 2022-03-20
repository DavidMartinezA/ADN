package com.example.domain.entity

import org.junit.Test

class MotoTest {

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrecto_NumeroPlacaNoVacio() {
        val motoTestNumeroPlaca = Moto("HSU531", true)
        val numeroPlaca = motoTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca.isNotEmpty())
    }

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaVacio_NumeroPlacaVacio() {
        val motoTestNumeroPlaca = Moto("", true)
        val numeroPlaca = motoTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca.isEmpty())
    }

    @Test
    fun obtenerCilindrajeAlto_cilindrajeAltoTrue_cilindrajeAltoTrue() {
        val motoTestCilindrajeAlto = Moto("HSU531", true)
        val cilindrajeAlto = motoTestCilindrajeAlto.cilindrajeAlto

        assert(cilindrajeAlto)
    }

    @Test
    fun obtenerCilindrajeAlto_cilindrajeAltoFalse_cilindrajeAltoFalse() {
        val motoTestCilindrajeAlto = Moto("HSU531", false)
        val cilindrajeAlto = motoTestCilindrajeAlto.cilindrajeAlto

        assert(!cilindrajeAlto)
    }

}