package com.example.domain.repository

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo

interface RepositorioVehiculo {

    fun vehiculoExiste(vehiculo: Vehiculo): Boolean

    fun guardarMoto(moto: Moto)

    fun guardarCarro(carro: Carro)

    fun eliminarVehiculo(vehiculo: Vehiculo)
}