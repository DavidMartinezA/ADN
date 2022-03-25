package com.example.dominio.estacionamiento

import com.example.dominio.cobro.CobroTarifaMoto
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioMoto
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.Temporal

class EstacionamientoMoto(override var vehiculo: Vehiculo, var servicioMoto: ServicioMoto) :
    EstacionamientoVehiculo(vehiculo) {

    companion object {
        const val CAPACIDAD_TOTAL_MOTOS = 10
    }

    override lateinit var horaIngreso: Temporal
    override lateinit var horaSalida: Temporal

    override suspend fun consutarCapacidad(): Boolean {
        val listaMotos: ArrayList<Vehiculo> = servicioMoto.consultarLista()
        return listaMotos.size <= CAPACIDAD_TOTAL_MOTOS
    }

    override suspend fun ingresoVehiculos(): Boolean {
        horaIngreso = LocalDateTime.of(LocalDate.now(), LocalTime.now())
        var vehiculoIngresado = false
        val capacidad = consutarCapacidad()
        if (capacidad) {
            servicioMoto.guardar(vehiculo)
            vehiculoIngresado = true
        }
        return vehiculoIngresado
    }

    override suspend fun salidaVehiculos(): Int {
        horaSalida = LocalDateTime.of(LocalDate.now(), LocalTime.now())
        val cobro = CobroTarifaMoto(duracionServicioEstacionamiento(horaIngreso, horaSalida),
            vehiculo).cobroTarifa()
        var tarifaTotal = 0
        if (servicioMoto.consultarLista().contains(vehiculo)) {
            tarifaTotal = cobro
        }
        return tarifaTotal
    }
}

