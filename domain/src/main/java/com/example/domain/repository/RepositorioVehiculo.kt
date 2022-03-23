package com.example.domain.repository

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo

interface RepositorioVehiculo {

    suspend fun vehiculoExiste(vehiculo: Vehiculo): Boolean

    suspend fun guardarMoto(moto: Moto)

    suspend fun guardarCarro(carro: Carro)

    suspend fun eliminarVehiculo(vehiculo: Vehiculo)
}