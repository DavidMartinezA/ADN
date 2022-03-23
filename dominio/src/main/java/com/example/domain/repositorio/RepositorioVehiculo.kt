package com.example.domain.repositorio

import com.example.domain.entidad.Carro
import com.example.domain.entidad.Moto
import com.example.domain.entidad.Vehiculo

interface RepositorioVehiculo {

    suspend fun vehiculoExiste(vehiculo: Vehiculo): Boolean

    suspend fun guardarMoto(moto: Moto) // todo deberia ser guardar vehiculo

    suspend fun guardarCarro(carro: Carro)

    suspend fun eliminarVehiculo(vehiculo: Vehiculo)
}