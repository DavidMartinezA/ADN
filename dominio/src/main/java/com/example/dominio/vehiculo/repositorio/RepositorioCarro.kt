package com.example.dominio.vehiculo.repositorio

import com.example.dominio.vehiculo.modelo.Carro
import com.example.dominio.vehiculo.modelo.Vehiculo

interface RepositorioCarro {

    suspend fun carroExiste(carro: Carro): Boolean

    suspend fun guardarCarro(carro: Carro)

    suspend fun eliminarCarro(carro: Carro)

    suspend fun listaCarros(): ArrayList<Vehiculo>
}
