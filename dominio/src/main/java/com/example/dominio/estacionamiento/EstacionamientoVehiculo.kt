package com.example.dominio.estacionamiento

import com.example.dominio.vehiculo.modelo.Vehiculo
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.Temporal

abstract class EstacionamientoVehiculo(protected open var vehiculo: Vehiculo) {

    companion object {
        val DIAS_PERMITIDOS = arrayListOf("Domingo", "Lunes")
        const val LETRA_RESTRINGIDA = 'A'
    }

    protected abstract var horaIngreso: Temporal
    protected abstract var horaSalida: Temporal

    fun restriccionIngreso(): Boolean {
        val diaSemana: String = LocalDateTime.now().dayOfWeek.toString()
        var restringido = false
        if (vehiculo.placaVehiculo.uppercase().first() == LETRA_RESTRINGIDA) {
            restringido = !DIAS_PERMITIDOS.contains(diaSemana)
        }
        return restringido
    }

    fun duracionServicioEstacionamiento(horaIngreso: Temporal, horaSalida: Temporal): Int {
        return Duration.between(horaIngreso, horaSalida).toString().toInt()
    }

    abstract suspend fun ingresoVehiculos(): Boolean

    abstract suspend fun salidaVehiculos(): Int

    abstract suspend fun consutarCapacidad(): Boolean
}
