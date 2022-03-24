package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo


class IngresoMoto(
    override var placaVehiculo: String,
    var cilindrajeAlto: Boolean = false,
    var listaMoto: ArrayList<Moto>= ServicioMoto.) : IngresoVehiculo(placaVehiculo) {

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