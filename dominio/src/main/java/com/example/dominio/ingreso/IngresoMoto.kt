package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioMoto

class IngresoMoto(var vehiculo: Vehiculo, var servicioMoto: ServicioMoto) :
    IngresoVehiculo(vehiculo) {

    companion object {
        const val CAPACIDAD_TOTAL_MOTOS = 10
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaCarros: ArrayList<Vehiculo> = servicioMoto.consultarLista()
        return listaCarros.size <= ServicioMoto.CAPACIDAD_TOTAL_MOTOS
    }

    override suspend fun ingresoVehiculos(diaSemana: String): Boolean {
        var vehiculoIngresado = false
        val capacidad = servicioMoto.consutarCapacidad()
        if (capacidad) {
            servicioMoto.guardar(vehiculo)
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

}
