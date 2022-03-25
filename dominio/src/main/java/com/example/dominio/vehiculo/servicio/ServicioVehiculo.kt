package com.example.dominio.vehiculo.servicio

import com.example.dominio.vehiculo.modelo.Vehiculo

abstract class ServicioVehiculo {

    abstract suspend fun guardar(): Boolean

    abstract suspend fun eliminar(): Boolean

    abstract suspend fun consultarLista(): ArrayList<Vehiculo>
}

