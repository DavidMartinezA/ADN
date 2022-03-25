package com.example.dominio.vehiculo.servicio

import com.example.dominio.vehiculo.modelo.Vehiculo

abstract class ServicioVehiculo {

    abstract suspend fun guardar(vehiculo: Vehiculo): Boolean

    abstract suspend fun eliminar(vehiculo: Vehiculo): Boolean

    abstract suspend fun consultarLista(): ArrayList<Vehiculo>
}

