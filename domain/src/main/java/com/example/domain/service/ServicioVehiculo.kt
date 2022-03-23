package com.example.domain.service

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo
import com.example.domain.repository.RepositorioVehiculo

class ServicioVehiculo(var repositorioVehiculo: RepositorioVehiculo) {


    fun guardarVehiculo(vehiculo: Vehiculo): Boolean {
        var vehiculoGuardado = false

        when (vehiculo) {
            is Carro -> {
                vehiculoGuardado = if (repositorioVehiculo?.vehiculoExiste(vehiculo) == true) {
                    false
                } else {
                    repositorioVehiculo?.guardarCarro(vehiculo)
                    true
                }
            }
            is Moto -> {
                vehiculoGuardado = if (repositorioVehiculo?.vehiculoExiste(vehiculo) == true) {
                    false
                } else {
                    repositorioVehiculo?.guardarMoto(vehiculo)
                    true
                }
            }
        }
        return vehiculoGuardado

    }

}
