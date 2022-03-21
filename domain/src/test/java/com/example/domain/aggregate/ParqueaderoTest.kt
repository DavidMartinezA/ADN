package com.example.domain.aggregate

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo
import org.junit.Test

class ParqueaderoTest {

    @Test
    fun ingresoVehiculos_PlacaNoVacia_IngresoPermitido() {

        //Arrange
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("HSU531")
        //Act
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Domingo")
        //Assert
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaVacia_IngresoNoPermitido() {

        //Arrange
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("")
        //Act
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Domingo")
        //Assert
        assert(restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaMayuscula_IngresoPermitido() {

        //Arrange
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("HSU531")
        //Act
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Domingo")
        //Assert
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_PlacaMinuscula_IngresoPermitido() {

        //Arrange
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("hsu531")
        //Act
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "domingo")
        //Assert
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_DiaPermitido_IngresoPermitido() {

        //Arrange
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("Asu531")
        //Act
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Domingo")
        //Assert
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_DiaPermitidouno_IngresoPermitido() {

        //Arrange
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("Asu531")
        //Act
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, "Lunes")
        //Assert
        assert(!restringido)
    }

    @Test
    fun ingresoVehiculos_DiaNoPermitido_IngresoNoPermitido() {

        //Arrange
        val ingresoParqueadero = Parqueadero()
        val carroJuan: Vehiculo = Carro("Asu531")
        val dia = "Jueves"
        //Act
        val restringido = ingresoParqueadero.ingresoVehiculos(carroJuan, dia)
        //Assert
        assert(restringido)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnHorasAltoCilindraje_TarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 8
        val moto = Moto("hsu531", true)
        //Act
        val cobro = parqueadero.cobroTarifaMoto(duracionServicioHoras, moto)
        //Assert
        assert(cobro == 6000)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnHorasAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 8
        val moto = Moto("hsu531", false)
        //Act
        val cobro = parqueadero.cobroTarifaMoto(duracionServicioHoras, moto)
        //Assert
        assert(cobro == 4000)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnDiasAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 16
        val moto = Moto("hsu531", false)
        //Act
        val cobro = parqueadero.cobroTarifaMoto(duracionServicioHoras, moto)
        //Assert
        assert(cobro == 4000)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnDiasHorasAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 50
        val moto = Moto("hsu531", false)
        //Act
        val cobro = parqueadero.cobroTarifaMoto(duracionServicioHoras, moto)
        //Assert
        assert(cobro == 9000)
    }

    @Test
    fun cobroTarifaCarro_TiempoUnDia_TarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 14
        val carro = Carro("hsu531")
        //Act
        val cobro = parqueadero.cobroTarifaCarro(duracionServicioHoras, carro)
        //Assert
        assert(cobro == 8000)
    }

    @Test
    fun cobroTarifaCarro_TiempoEnHoras_TarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 6
        val carro = Carro("hsu531")
        //Act
        val cobro = parqueadero.cobroTarifaCarro(duracionServicioHoras, carro)
        //Assert
        assert(cobro == 6000)
    }

    @Test
    fun cobroTarifaCarro_TiempoEnDias_TarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 50
        val carro = Carro("hsu531")
        //Act
        val cobro = parqueadero.cobroTarifaCarro(duracionServicioHoras, carro)
        //Assert
        assert(cobro == 18000)
    }


    @Test
    fun salidaVehiculos_SalidaCarroHoras_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 6
        val carro = Carro("hsu531")
        parqueadero.listaVehiculo.add(carro)
        //Act
        val tarifa = parqueadero.salidaVehiculos(carro, duracionServicioHoras)
        //Assert
        assert(tarifa == 6000)
    }

    @Test
    fun salidaVehiculos_SalidaCarroDias_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 60
        val carro = Carro("hsu531")
        parqueadero.listaVehiculo.add(carro)
        //Act
        val tarifa = parqueadero.salidaVehiculos(carro, duracionServicioHoras)
        //Assert
        assert(tarifa == 24000)
    }


    @Test
    fun salidaVehiculos_SalidaCarroUnDia_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 9
        val carro = Carro("hsu531")
        parqueadero.listaVehiculo.add(carro)
        //Act
        val tarifa = parqueadero.salidaVehiculos(carro, duracionServicioHoras)
        //Assert
        assert(tarifa == 8000)
    }

    @Test
    fun salidaVehiculos_SalidaMotoDias_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 58
        val moto = Moto("hsu531")
        parqueadero.listaVehiculo.add(moto)
        //Act
        val tarifa = parqueadero.salidaVehiculos(moto, duracionServicioHoras)
        //Assert
        assert(tarifa == 12000)
    }

    @Test
    fun salidaVehiculos_SalidaMotoDiasCilindrajeAlto_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 58
        val moto = Moto("hsu531", true)
        parqueadero.listaVehiculo.add(moto)
        //Act
        val tarifa = parqueadero.salidaVehiculos(moto, duracionServicioHoras)
        //Assert
        assert(tarifa == 14000)
    }

    @Test
    fun salidaVehiculos_SalidaMotoUnDia_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 9
        val moto = Moto("hsu531")
        parqueadero.listaVehiculo.add(moto)
        //Act
        val tarifa = parqueadero.salidaVehiculos(moto, duracionServicioHoras)
        //Assert
        assert(tarifa == 4000)
    }

    @Test
    fun salidaVehiculos_SalidaMotoUnDiaCilindrajeAlto_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 9
        val moto = Moto("hsu531", true)
        parqueadero.listaVehiculo.add(moto)
        //Act
        val tarifa = parqueadero.salidaVehiculos(moto, duracionServicioHoras)
        //Assert
        assert(tarifa == 6000)
    }

    @Test
    fun salidaVehiculos_SalidaMotoUnHorasCilindrajeAlto_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 6
        val moto = Moto("hsu531", true)
        parqueadero.listaVehiculo.add(moto)
        //Act
        val tarifa = parqueadero.salidaVehiculos(moto, duracionServicioHoras)
        //Assert
        assert(tarifa == 5000)
    }

    @Test
    fun salidaVehiculos_SalidaMotoUnDiaHoras_tarifaParqueo() {

        //Arrange
        val parqueadero = Parqueadero()
        val duracionServicioHoras = 6
        val moto = Moto("hsu531", false)
        parqueadero.listaVehiculo.add(moto)
        //Act
        val tarifa = parqueadero.salidaVehiculos(moto, duracionServicioHoras)
        //Assert
        assert(tarifa == 3000)
    }
}