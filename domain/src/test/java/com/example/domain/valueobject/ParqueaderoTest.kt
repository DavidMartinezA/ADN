package com.example.domain.valueobject

import com.example.domain.aggregate.Parqueadero
import com.example.domain.entity.Carro
import com.example.domain.entity.Vehiculo

import org.junit.Test

class ParqueaderoTest {

    @Test
    fun ingresoVehiculos_PlacaNoVacia_IngresoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("HSU531")
        ingresoParqueadero.ingresoVehiculos(carroJuan,"domingo")
        val restringido = ingresoParqueadero.restringido
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaVacia_IngresoNoPermitido() {
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("")
        ingresoParqueadero.ingresoVehiculos(carroJuan,"domingo")
        val restringido = ingresoParqueadero.restringido
        assert(restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaMayuscula_IngresoPermitido() {
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("HSU531")
        ingresoParqueadero.ingresoVehiculos(carroJuan,"domingo")
        val restringido = ingresoParqueadero.restringido
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaMinuscula_IngresoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("hsu531")
        ingresoParqueadero.ingresoVehiculos(carroJuan,"domingo")
        val restringido = ingresoParqueadero.restringido
        assert(!restringido)
    }

    @Test
    fun cobroTarifaMoto() {
    }

    @Test
    fun cobroTarifaCarro() {
    }

    @Test
    fun salidaVehiculos() {
    }
}