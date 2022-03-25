package com.example.dominio.vehiculo.repositorio

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo

interface RepositorioMoto {

    suspend fun motoExiste(moto: Moto): Boolean

    suspend fun guardarMoto(moto: Moto)

    suspend fun eliminarMoto(moto: Moto)

    suspend fun listaMotos(): ArrayList<Vehiculo>
}
