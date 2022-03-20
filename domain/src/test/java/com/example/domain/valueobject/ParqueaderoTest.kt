package com.example.domain.valueobject

import com.example.domain.aggregate.Parqueadero
import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo

import org.junit.Test

class ParqueaderoTest {

    @Test
    fun ingresoVehiculos_PlacaNoVacia_IngresoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("HSU531")
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Domingo")
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaVacia_IngresoNoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("")
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Domingo")
        assert(restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaMayuscula_IngresoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("HSU531")
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "domingo")
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaMinuscula_IngresoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("hsu531")
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "domingo")
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_DiaPermitido_IngresoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("Asu531")
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Domingo")
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_DiaPermitidouno_IngresoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("Asu531")
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Lunes")
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_DiaNoPermitido_IngresoNoPermitido() {

        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("Asu531")
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Jueves")
        assert(restringido)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnHorasAltoCilindraje_TarifaParqueo() {

        val parqueadero = Parqueadero()
        val duracionServicioHoras = 8
        val moto = Moto("hsu531", true)

        val cobro = parqueadero.cobroTarifaMoto(duracionServicioHoras, moto)
        assert(cobro == 6000)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnHorasAltoCilindrajeFalse_TarifaParqueo() {

        val parqueadero = Parqueadero()
        val duracionServicioHoras = 8
        val moto = Moto("hsu531", false)

        val cobro = parqueadero.cobroTarifaMoto(duracionServicioHoras, moto)
        assert(cobro == 4000)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnDiasAltoCilindrajeFalse_TarifaParqueo() {

        val parqueadero = Parqueadero()
        val duracionServicioHoras = 16
        val moto = Moto("hsu531", false)

        val cobro = parqueadero.cobroTarifaMoto(duracionServicioHoras, moto)
        assert(cobro == 4000)
    }

    /* @Test
     fun cobroTarifaMoto_TiempoEnDiasHorasAltoCilindrajeFalse_TarifaParqueo() {

         val parqueadero = Parqueadero()
         val duracionServicioHoras = 25
         val moto = Moto("hsu531", false)

         val cobro = parqueadero.cobroTarifaMoto(duracionServicioHoras,moto)
         assert(cobro == 4000)
     }*/
    @Test
    fun cobroTarifaCarro() {
    }

    @Test
    fun salidaVehiculos() {
    }
}