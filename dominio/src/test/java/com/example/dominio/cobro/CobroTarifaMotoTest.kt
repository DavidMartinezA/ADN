package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Moto
import org.junit.Test

class CobroTarifaMotoTest {

    @Test
    fun cobroTarifaMoto_TiempoEnHorasAltoCilindraje_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu-531", true)
        val duracionServicioEstacionamiento = 6
        //Act
        val cobro = CobroTarifaMoto(duracionServicioEstacionamiento, moto).cobroTarifa()
        //Assert
        assert(cobro == 5000)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnHorasAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu-531", false)
        val duracionServicioEstacionamiento = 6
        //Act
        val cobro = CobroTarifaMoto(duracionServicioEstacionamiento, moto).cobroTarifa()
        //Assert
        assert(cobro == 3000)
    }

    @Test
    fun cobroTarifaMoto_TiempoEnDiasAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu-531", false)
        val duracionServicioEstacionamiento = 50
        //Act
        val cobro = CobroTarifaMoto(duracionServicioEstacionamiento, moto).cobroTarifa()
        //Assert
        assert(cobro == 9000)
    }

    @Test
    fun cobroTarifaMoto_TiempoDiaAltoCilindrajeFalse_TarifaParqueo() {

        //Arrange
        val moto: Moto = Moto("hsu531", false)
        val duracionServicioEstacionamiento = 9
        //Act
        val cobro = CobroTarifaMoto(duracionServicioEstacionamiento, moto).cobroTarifa()
        //Assert
        assert(cobro == 4000)
    }
}
