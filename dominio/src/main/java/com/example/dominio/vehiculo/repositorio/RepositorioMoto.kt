package com.example.dominio.vehiculo.repositorio

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo

interface RepositorioMoto {

    suspend fun motoExiste(vehiculo: Vehiculo): Boolean

    suspend fun guardarMoto(moto: Moto)

    suspend fun eliminarMoto(vehiculo: Vehiculo)

    suspend fun listaMotos(): ArrayList<Vehiculo>
}
