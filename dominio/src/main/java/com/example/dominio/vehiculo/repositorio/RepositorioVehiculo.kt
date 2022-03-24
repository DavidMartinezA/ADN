package com.example.dominio.vehiculo.repositorio

import com.example.dominio.vehiculo.modelo.Carro
import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo

interface RepositorioVehiculo {

    suspend fun vehiculoExiste(vehiculo: Vehiculo): Boolean

    suspend fun guardarMoto(moto: Moto) // todo deberia ser guardar vehiculo

    suspend fun guardarCarro(carro: Carro)

    suspend fun eliminarVehiculo(vehiculo: Vehiculo)
}