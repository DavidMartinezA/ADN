package com.example.dominio.ingreso


import com.example.dominio.cobro.CobroTarifa
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioMoto
import java.time.LocalDate

class IngresoMoto(var vehiculo: Vehiculo, var servicioMoto: ServicioMoto) :
    IngresoVehiculo(vehiculo) {

    private var horaIngreso: Int = 0
    private var horaSalida: Int = 0

    companion object {
        const val CAPACIDAD_TOTAL_MOTOS = 10
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaMotos: ArrayList<Vehiculo> = servicioMoto.consultarLista()
        return listaMotos.size <= CAPACIDAD_TOTAL_MOTOS
    }

    override suspend fun ingresoVehiculos(): Boolean {
        var vehiculoIngresado = false
        val capacidad = consutarCapacidad()
        horaIngreso = LocalDate.now().dayOfWeek.value
        if (capacidad) {
            servicioMoto.guardar(vehiculo)
            vehiculoIngresado = true

        }
        return vehiculoIngresado
    }

    override suspend fun salidaVehiculos(vehiculo: Vehiculo): Int {
        horaSalida = LocalDate.now().dayOfWeek.value
        var tarifaTotal = 0
        if (servicioMoto.consultarLista().contains(vehiculo)) {
            tarifaTotal = CobroTarifa.servicioMoto.eliminar(vehiculo)
        }
        return tarifaTotal
    }

    override fun duracionServicioEstacionamiento(): Int {
        horaIngreso
        horaSalida
        return 0
    }

}
