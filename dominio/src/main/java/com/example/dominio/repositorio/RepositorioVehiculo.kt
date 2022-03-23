package com.example.dominio.repositorio

import com.example.dominio.modelo.Carro
import com.example.dominio.modelo.Moto
import com.example.dominio.modelo.Vehiculo

interface RepositorioVehiculo {

    suspend fun vehiculoExiste(vehiculo: Vehiculo): Boolean

    suspend fun guardarMoto(moto: Moto) // todo deberia ser guardar vehiculo

    suspend fun guardarCarro(carro: Carro)

    suspend fun eliminarVehiculo(vehiculo: Vehiculo)
}