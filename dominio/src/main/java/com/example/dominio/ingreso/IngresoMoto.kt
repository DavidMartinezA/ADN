package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.servicio.ServicioVehiculo

class IngresoMoto(
    override var placaVehiculo: String,
    var cilindrajeAlto: Boolean = false,
    var listaMoto: ServicioVehiculo,
) : IngresoVehiculo(placaVehiculo) {

    override fun ingresoVehiculos(diaSemana: String): Boolean {
        var vehiculoIngresado = false

        val cuantasMotos = listaMoto.size
        hayCupo = cuantasMotos <= CapacidadEstacionamiento.LIMITE_MOTO
        if (restriccionIngreso(vehiculo, diaSemana) && hayCupo) {
            listaMoto.add(vehiculo)
            vehiculoIngresado = true
        }

    }

    override fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int {
        TODO("Not yet implemented")
    }
}