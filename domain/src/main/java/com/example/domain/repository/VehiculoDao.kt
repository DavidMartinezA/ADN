package com.example.domain.repository

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo

@Dao
interface VehiculoDao {
    @Insert
    fun insertAll(vararg vehiculo: Vehiculo)

    @Delete
    fun delete(vehiculo: Vehiculo)

    @Query("SELECT * FROM user")
    fun getAllMotos(): List<Moto>

    @Query("SELECT * FROM user")
    fun getAllCarros(): List<Carro>

    @Query("SELECT * FROM user")
    fun getAllVehiculos(): List<Vehiculo>
}