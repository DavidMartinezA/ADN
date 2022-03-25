package com.example.dominio.estacionamiento

import com.example.dominio.cobro.CobroTarifaCarro
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioCarro
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.Temporal

class EstacionamientoCarro(override var vehiculo: Vehiculo, var servicioCarro: ServicioCarro) :
    EstacionamientoVehiculo(vehiculo) {

    companion object {
        const val CAPACIDAD_TOTAL_CARROS = 20
    }

    override lateinit var horaIngreso: Temporal
    override lateinit var horaSalida: Temporal

    override suspend fun consutarCapacidad(): Boolean {
        val listaCarros: ArrayList<Vehiculo> = servicioCarro.consultarLista()
        return listaCarros.size <= CAPACIDAD_TOTAL_CARROS
    }

    override suspend fun ingresoVehiculos(): Boolean {
        horaIngreso = LocalDateTime.of(LocalDate.now(), LocalTime.now())
        var vehiculoIngresado = false
        val capacidad = consutarCapacidad()
        if (capacidad && !restriccionIngreso()) {
            servicioCarro.guardar(vehiculo)
            vehiculoIngresado = true
        }
        return vehiculoIngresado
    }

    override suspend fun salidaVehiculos(): Int {
        horaSalida = LocalDateTime.of(LocalDate.now(), LocalTime.now())
        val cobro = CobroTarifaCarro(duracionServicioEstacionamiento(horaIngreso, horaSalida),
            vehiculo).cobroTarifa()
        var tarifaTotal = 0
        if (servicioCarro.consultarLista().contains(vehiculo)) {
            tarifaTotal = cobro
        }
        return tarifaTotal
    }
}
