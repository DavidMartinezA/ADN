package com.example.domain.objetoDeValor

import com.example.domain.entidad.Vehiculo

interface Ingreso {

    fun restriccionIngreso(vehiculo: Vehiculo,  diaSemana :String): Boolean

    fun ingresoVehiculos(vehiculo: Vehiculo, diaSemana :String): Boolean

    fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int


}