package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Vehiculo

abstract class IngresoVehiculo(open var placaVehiculo: String) {
    companion object {
        val DIAS_PERMITIDOS = arrayListOf("Domingo", "Lunes")
    }

    fun restriccionIngreso(vehiculo: Vehiculo, diaSemana: String): Boolean {

        var restringido = false

        if (vehiculo.placaVehiculo.first() == CapacidadEstacionamiento.LETRA_RESTRINGIDA) {
            restringido = !DIAS_PERMITIDOS.contains(diaSemana)
        }

        return restringido

    }

    abstract fun ingresoVehiculos(diaSemana: String): Boolean

    abstract fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int
}