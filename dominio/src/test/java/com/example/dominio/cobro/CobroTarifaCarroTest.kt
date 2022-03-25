package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Carro
import org.junit.Test

class CobroTarifaCarroTest {

    @Test
    fun cobroTarifaCarro_TiempoUnDiaCarro_TarifaParqueo() {

        //Arrange
        val carro: Carro = Carro("hsu531")
        val duracionServicioEstacionamiento = 9
        //Act
        val cobro = CobroTarifaCarro().cobroTarifa(duracionServicioEstacionamiento, carro)
        //Assert
        assert(cobro == 8000)
    }

    @Test
    fun cobroTarifaCarro_TiempoEnHorasCarro_TarifaParqueo() {

        //Arrange
        val carro: Carro = Carro("hsu531")
        val duracionServicioEstacionamiento = 6
        //Act
        val cobro = CobroTarifaCarro().cobroTarifa(duracionServicioEstacionamiento, carro)
        //Assert
        assert(cobro == 6000)
    }

    @Test
    fun cobroTarifaCarro_TiempoEnDiasCarro_TarifaParqueo() {

        //Arrange
        val carro: Carro = Carro("hsu531")
        val duracionServicioEstacionamiento = 50
        //Act
        val cobro = CobroTarifaCarro().cobroTarifa(duracionServicioEstacionamiento, carro)
        //Assert
        assert(cobro == 18000)
    }

    @Test
    fun cobroTarifaCarro_TiempoNegativo_TarifaParqueo() {

        //Arrange
        val carro: Carro = Carro("hsu531")
        val duracionServicioEstacionamiento = -50
        //Act
        val cobro = CobroTarifaCarro().cobroTarifa(duracionServicioEstacionamiento, carro)
        //Assert
        assert(cobro == 0)
    }

    @Test
    fun cobroTarifaCarro_TiempoExtremo_TarifaParqueo() {

        //Arrange
        val carro: Carro = Carro("hsu531")
        val duracionServicioEstacionamiento = 999
        //Act
        val cobro = CobroTarifaCarro().cobroTarifa(duracionServicioEstacionamiento, carro)
        //Assert
        assert(cobro == 336000)
    }

    @Test
    fun cobroTarifaCarro_TiempoExtremoDos_TarifaParqueo() {

        //Arrange
        val carro: Carro = Carro("hsu531")
        val duracionServicioEstacionamiento = 2376
        //Act
        val cobro = CobroTarifaCarro().cobroTarifa(duracionServicioEstacionamiento, carro)
        //Assert
        assert(cobro == 792000)
    }
}
