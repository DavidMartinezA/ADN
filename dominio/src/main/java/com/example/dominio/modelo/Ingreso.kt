package com.example.dominio.modelo

interface Ingreso {

    fun restriccionIngreso(vehiculo: Vehiculo,  diaSemana :String): Boolean

    fun ingresoVehiculos(vehiculo: Vehiculo, diaSemana :String): Boolean

    fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int


}