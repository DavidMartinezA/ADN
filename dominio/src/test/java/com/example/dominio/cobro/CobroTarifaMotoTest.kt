package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Moto
import org.junit.Test

class CobroTarifaMotoTest {

    @Test
    fun cobroTarifa_MotoTiempoEnHorasAltoCilindraje_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu-531", true)
        val duracionServicioEstacionamiento = 6
        //Act
        val cobro = CobroTarifaMoto().cobroTarifa(duracionServicioEstacionamiento, moto)
        //Assert
        assert(cobro == 5000)
    }

    @Test
    fun cobroTarifa_MotoTiempoEnHorasAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu-531", false)
        val duracionServicioEstacionamiento = 6
        //Act
        val cobro = CobroTarifaMoto().cobroTarifa(duracionServicioEstacionamiento, moto)
        //Assert
        assert(cobro == 3000)
    }

    @Test
    fun cobroTarifa_MotoTiempoEnDiasAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu-531", false)
        val duracionServicioEstacionamiento = 50
        //Act
        val cobro = CobroTarifaMoto().cobroTarifa(duracionServicioEstacionamiento, moto)
        //Assert
        assert(cobro == 9000)
    }

    @Test
    fun cobroTarifa_MotoTiempoDiaAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu531", false)
        val duracionServicioEstacionamiento = 9
        //Act
        val cobro = CobroTarifaMoto().cobroTarifa(duracionServicioEstacionamiento, moto)
        //Assert
        assert(cobro == 4000)
    }

    @Test
    fun cobroTarifa_MotoTiempoNegativoAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu531", false)
        val duracionServicioEstacionamiento = -22
        //Act
        val cobro = CobroTarifaMoto().cobroTarifa(duracionServicioEstacionamiento, moto)
        //Assert
        assert(cobro == 0)
    }
}
