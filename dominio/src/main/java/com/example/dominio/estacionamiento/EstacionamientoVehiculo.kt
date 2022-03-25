package com.example.dominio.estacionamiento

import com.example.dominio.cobro.CobroTarifaCarro
import com.example.dominio.vehiculo.modelo.Vehiculo
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.Temporal

abstract class EstacionamientoVehiculo(var vehiculo: Vehiculo) {

    companion object {
        val DIAS_PERMITIDOS = arrayListOf(7, 1)
        const val LETRA_RESTRINGIDA = 'A'
    }

    private lateinit var horaIngreso: Temporal

    fun restriccionIngreso(): Boolean {
        val diaSemana = LocalDateTime.now().dayOfWeek.value
        var restringido = false
        if (vehiculo.placaVehiculo.uppercase().first() == LETRA_RESTRINGIDA) {
            restringido = !DIAS_PERMITIDOS.contains(diaSemana)
        }
        return restringido
    }

    private fun duracionServicioEstacionamiento(horaIngreso: Temporal, horaSalida: Temporal): Int {
        return Duration.between(horaIngreso, horaSalida).toString().toInt()
    }

    open suspend fun ingreso(): Boolean {
        horaIngreso = LocalDateTime.now()
        return consutarCapacidad()
    }

    open suspend fun salida(): Int {
        val horaSalida = LocalDateTime.now()

        return CobroTarifaCarro().cobroTarifa(duracionServicioEstacionamiento(horaIngreso,
            horaSalida),
            vehiculo)
    }

    abstract suspend fun consutarCapacidad(): Boolean
}
