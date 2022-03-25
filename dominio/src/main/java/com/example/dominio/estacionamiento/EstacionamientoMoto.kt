package com.example.dominio.estacionamiento

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioMoto

class EstacionamientoMoto(var moto: Vehiculo, private var servicioMoto: ServicioMoto) :
    EstacionamientoVehiculo(moto) {

    companion object {
        const val CAPACIDAD_TOTAL_MOTOS = 10
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaMotos: ArrayList<Vehiculo> = servicioMoto.consultarLista()
        return listaMotos.size <= CAPACIDAD_TOTAL_MOTOS
    }

    override suspend fun ingreso(): Boolean {
        val capacidad = super.ingreso()
        var vehiculoIngresado = false
        if (capacidad && !restriccionIngreso() && vehiculo is Moto) {
            servicioMoto.guardar()
            vehiculoIngresado = true
        }
        return vehiculoIngresado
    }

    override suspend fun salida(): Int {
        var cobroDeServicio = 0
        val tarifaTotal = super.salida()
        if (servicioMoto.consultarLista().contains(moto)) {
            cobroDeServicio = tarifaTotal
        }
        return cobroDeServicio
    }
}

