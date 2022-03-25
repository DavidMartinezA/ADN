package com.example.dominio.estacionamiento

import com.example.dominio.vehiculo.modelo.Carro
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioCarro

class EstacionamientoCarro(var carro: Vehiculo, private var servicioCarro: ServicioCarro) :
    EstacionamientoVehiculo(carro) {

    companion object {
        const val CAPACIDAD_TOTAL_CARROS = 20
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaCarros: ArrayList<Vehiculo> = servicioCarro.consultarLista()
        return listaCarros.size <= CAPACIDAD_TOTAL_CARROS
    }

    override suspend fun ingreso(): Boolean {
        val capacidad = super.ingreso()
        var vehiculoIngresado = false
        if (capacidad && !restriccionIngreso() && vehiculo is Carro) {
            servicioCarro.guardar()
            vehiculoIngresado = true
        }
        return vehiculoIngresado
    }

    override suspend fun salida(): Int {
        var cobroDeServicio = 0
        val tarifaTotal = super.salida()
        if (servicioCarro.consultarLista().contains(carro)) {
            cobroDeServicio = tarifaTotal
        }
        return cobroDeServicio
    }
}
