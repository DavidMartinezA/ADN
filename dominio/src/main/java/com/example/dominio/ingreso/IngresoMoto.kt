package com.example.dominio.ingreso


import com.example.dominio.cobro.CobroTarifa
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioMoto
import java.time.LocalDate

class IngresoMoto(override var vehiculo: Vehiculo, var servicioMoto: ServicioMoto) :
    IngresoVehiculo(vehiculo) {

    companion object {
        const val CAPACIDAD_TOTAL_MOTOS = 10
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaMotos: ArrayList<Vehiculo> = servicioMoto.consultarLista()
        return listaMotos.size <= CAPACIDAD_TOTAL_MOTOS
    }

    override suspend fun ingresoVehiculos(): Boolean {
        horaIngreso = LocalDate.now().dayOfWeek.value
        var vehiculoIngresado = false
        val capacidad = consutarCapacidad()
        if (capacidad) {
            servicioMoto.guardar(vehiculo)
            vehiculoIngresado = true

        }
        return vehiculoIngresado
    }

    override suspend fun salidaVehiculos(): Int {
        horaSalida = LocalDate.now().dayOfWeek.value
        val cobro = CobroTarifa(duracionServicioEstacionamiento(), vehiculo).cobroTarifaMoto()
        var tarifaTotal = 0
        if (servicioMoto.consultarLista().contains(vehiculo)) {
            tarifaTotal = cobro
        }
        return tarifaTotal
    }

}
