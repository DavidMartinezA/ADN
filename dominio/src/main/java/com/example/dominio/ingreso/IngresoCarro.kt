package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Vehiculo

class IngresoCarro(placaVehiculo: String, var diaSemana: String) : IngresoVehiculo(placaVehiculo) {


    override suspend fun ingresoVehiculos(diaSemana: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int {
        TODO("Not yet implemented")
    }
}