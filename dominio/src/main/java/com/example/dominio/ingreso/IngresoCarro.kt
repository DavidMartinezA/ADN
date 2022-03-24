package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Vehiculo

class IngresoCarro(placaVehiculo: String) : IngresoVehiculo(placaVehiculo) {

    override fun ingresoVehiculos(vehiculo: Vehiculo, diaSemana: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int {
        TODO("Not yet implemented")
    }
}