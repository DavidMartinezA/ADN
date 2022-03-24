package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Vehiculo

abstract class IngresoVehiculo(Vehiculo: Vehiculo) {
    companion object {
        val DIAS_PERMITIDOS = arrayListOf("Domingo", "Lunes")
        const val LETRA_RESTRINGIDA = 'A'
    }

    fun restriccionIngreso(vehiculo: Vehiculo, diaSemana: String): Boolean {
        var restringido = false
        if (vehiculo.placaVehiculo.first() == LETRA_RESTRINGIDA) {
            restringido = !DIAS_PERMITIDOS.contains(diaSemana)
        }
        return restringido
    }

    abstract suspend fun ingresoVehiculos(): Boolean

    abstract suspend fun salidaVehiculos(): Int

    abstract suspend fun consutarCapacidad(): Boolean

    abstract fun duracionServicioEstacionamiento(): Int


}