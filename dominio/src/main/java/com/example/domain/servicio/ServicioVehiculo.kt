package com.example.domain.servicio

import com.example.domain.entidad.Carro
import com.example.domain.entidad.Moto
import com.example.domain.entidad.Vehiculo
import com.example.domain.repositorio.RepositorioVehiculo

class ServicioVehiculo(var repositorioVehiculo: RepositorioVehiculo) { // aplicar herencia


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
