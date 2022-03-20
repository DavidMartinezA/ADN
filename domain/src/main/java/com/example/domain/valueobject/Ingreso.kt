package com.example.domain.valueobject

import com.example.domain.entity.Vehiculo

interface Ingreso {

    fun restriccionIngreso(vehiculo: Vehiculo,  diaSemana :String): Boolean

    fun ingresoVehiculos(vehiculo: Vehiculo, diaSemana :String): Boolean

    fun salidaVehiculos(vehiculo: Vehiculo): Boolean


}