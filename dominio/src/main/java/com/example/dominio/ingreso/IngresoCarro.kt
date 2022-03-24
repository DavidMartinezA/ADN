package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioCarro

class IngresoCarro(var vehiculo: Vehiculo, var servicioCarro: ServicioCarro) :
    IngresoVehiculo(vehiculo) {

    companion object {
        const val CAPACIDAD_TOTAL_CARROS = 20
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaCarros: ArrayList<Vehiculo> = servicioCarro.consultarLista()
        return listaCarros.size <= CAPACIDAD_TOTAL_CARROS
    }

    override suspend fun ingresoVehiculos(diaSemana: String): Boolean {
        var vehiculoIngresado = false
        val capacidad = consutarCapacidad()
        if (capacidad) {
            servicioCarro.guardar(vehiculo)
            vehiculoIngresado = true

        }
        return vehiculoIngresado
    }

    override suspend fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int {
        var tarifaTotal = 0
        if (servicioMoto.consultarLista().contains(vehiculo)) {
            tarifaTotal = cobroTarifaMoto(duracionServicio, vehiculo)
            servicioMoto.eliminar(vehiculo)
        }
        return tarifaTotal
    }

    override suspend fun duracionServicioEstacionamiento(): Int {
        return 0
    }
}