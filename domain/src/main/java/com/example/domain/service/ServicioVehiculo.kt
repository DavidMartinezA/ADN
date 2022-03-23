package com.example.domain.service

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo
import com.example.domain.repository.RepositorioVehiculo

class ServicioVehiculo(var repositorioVehiculo: RepositorioVehiculo) {


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
