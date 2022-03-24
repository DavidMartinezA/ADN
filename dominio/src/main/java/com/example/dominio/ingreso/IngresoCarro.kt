package com.example.dominio.ingreso

import com.example.dominio.cobro.CobroTarifaCarro
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioCarro
import java.time.LocalDate

class IngresoCarro(override var vehiculo: Vehiculo, var servicioCarro: ServicioCarro) :
    IngresoVehiculo(vehiculo) {

    companion object {
        const val CAPACIDAD_TOTAL_CARROS = 20
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaCarros: ArrayList<Vehiculo> = servicioCarro.consultarLista()
        return listaCarros.size <= CAPACIDAD_TOTAL_CARROS
    }

    override suspend fun ingresoVehiculos(): Boolean {
        horaIngreso = LocalDate.now().dayOfWeek.value
        var vehiculoIngresado = false
        val capacidad = consutarCapacidad()
        if (capacidad && !restriccionIngreso()) {
            servicioCarro.guardar(vehiculo)
            vehiculoIngresado = true
        }
        return vehiculoIngresado
    }

    override suspend fun salidaVehiculos(): Int {
        horaSalida = LocalDate.now().dayOfWeek.value
        val cobro = CobroTarifaCarro(duracionServicioEstacionamiento(), vehiculo).cobroTarifa()
        var tarifaTotal = 0
        if (servicioCarro.consultarLista().contains(vehiculo)) {
            tarifaTotal = cobro
        }
        return tarifaTotal
    }

}