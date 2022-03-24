package com.example.dominio.ingreso

import com.example.dominio.vehiculo.modelo.Vehiculo
import java.time.LocalDateTime

abstract class IngresoVehiculo(open var vehiculo: Vehiculo) {
    protected var horaIngreso: Int = 0
    protected var horaSalida: Int = 0

    companion object {
        val DIAS_PERMITIDOS = arrayListOf("Domingo", "Lunes")
        const val LETRA_RESTRINGIDA = 'A'
    }

    fun duracionServicioEstacionamiento(): Int {
        horaIngreso //todo  hacer calculo de duracion
        horaSalida
        return 0
    }

    fun restriccionIngreso(): Boolean {
        val diaSemana: String = LocalDateTime.now().dayOfWeek.toString()
        var restringido = false
        if (vehiculo.placaVehiculo.first() == LETRA_RESTRINGIDA) {
            restringido = !DIAS_PERMITIDOS.contains(diaSemana)
        }
        return restringido
    }

    abstract suspend fun ingresoVehiculos(): Boolean

    abstract suspend fun salidaVehiculos(): Int

    abstract suspend fun consutarCapacidad(): Boolean

}