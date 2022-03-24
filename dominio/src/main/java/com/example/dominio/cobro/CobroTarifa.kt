package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Vehiculo

abstract class CobroTarifa(
    open var duracionServicioEstacionamiento: Int = 0,
    open var vehiculo: Vehiculo,
) {

    var tarifaParqueoTotal = 0
    var diasCobro = 0
    var diasEnHoras = 0
    var horasCobro = 0

    companion object {
        const val VALOR_HORA_MOTO = 500
        const val VALOR_DIA_MOTO = 4000
        const val COBRO_ALTO_CILINDRAJE = 2000
        const val HORAS_EN_EL_DIA = 24
    }

    abstract fun cobroTarifa(): Int
}
