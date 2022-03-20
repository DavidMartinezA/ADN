package com.example.domain.entity

import org.junit.Assert.*

import org.junit.Test

class MotoTest {

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrecto_NumeroPlacaNoVacio() {
        var carroTestNumeroPlaca :Moto = Moto("HSU531")
        var numeroPlaca =carroTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca.isNotEmpty())
    }
}