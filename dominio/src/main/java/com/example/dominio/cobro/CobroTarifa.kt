package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Vehiculo

abstract class CobroTarifa(
    open var duracionServicioEstacionamiento: Int = 0,
    open var vehiculo: Vehiculo,
) {

    protected abstract var valorHora: Int
    protected abstract var valorDia: Int
    protected abstract var tarifaParqueoTotal: Int

    companion object {
        const val HORAS_EN_EL_DIA = 24
    }

    abstract fun cobroTarifa(): Int
}
