package com.example.dominio.vehiculo.servicio

import com.example.dominio.vehiculo.modelo.Carro
import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.repositorio.RepositorioVehiculo

abstract class ServicioVehiculo(var repositorioVehiculo: RepositorioVehiculo) { // aplicar herencia


    suspend fun guardarVehiculo(vehiculo: Vehiculo): Boolean {
        var vehiculoGuardado = false

        when (vehiculo) {
            is Carro -> {
                vehiculoGuardado = if (repositorioVehiculo.vehiculoExiste(vehiculo)) {
                    false
                } else {
                    repositorioVehiculo.guardarCarro(vehiculo)
                    true
                }
            }
            is Moto -> {
                vehiculoGuardado = if (repositorioVehiculo.vehiculoExiste(vehiculo)) {
                    false
                } else {
                    repositorioVehiculo.guardarMoto(vehiculo)
                    true
                }
            }
        }
        return vehiculoGuardado

    }

}
