package com.example.domain.entity

import org.junit.Test

class CarroTest {

    @Test
    fun obtenerNumeroPlaca_NumeroPlacaCorrecto_NumeroPlacaNoVacio() {
        var carroTestNumeroPlaca :Carro = Carro("HSU531")
        var numeroPlaca =carroTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca.isNotEmpty())
    }

    @Test
    fun obtenerNumeroPlacaMayusculas_NumeroPlacaCorrectoMayusculas_NumeroPlacaMayusculas() {
        var carroTestNumeroPlaca :Carro = Carro("HSU531")
        var numeroPlaca =carroTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca.equals(numeroPlaca.uppercase()))
    }

    @Test
    fun obtenerNumeroPlacaMayusculas_NumeroPlacaCorrectoMinusculas_NumeroPlacaMayusculas() {
        var carroTestNumeroPlaca :Carro = Carro("hsu531")
        var numeroPlaca =carroTestNumeroPlaca.numeroPlaca

        assert(numeroPlaca.equals(numeroPlaca.uppercase()))
    }


}