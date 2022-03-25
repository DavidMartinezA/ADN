package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo

class CobroTarifaMoto : CobroTarifa() {
    override val valorHora = 500
    override val valorDia = 4000

    companion object {
        private const val COBRO_ADICIONAL_ALTO_CILINDRAJE = 2000
    }

    override fun cobroTarifa(duracionServicioEstacionamiento: Int, vehiculo: Vehiculo): Int {
        var tarifaParqueoTotal = super.cobroTarifa(duracionServicioEstacionamiento, vehiculo)

        if ((vehiculo as? Moto)?.cilindrajeAlto == true) {
            tarifaParqueoTotal += COBRO_ADICIONAL_ALTO_CILINDRAJE
        }
        return tarifaParqueoTotal
    }
}
