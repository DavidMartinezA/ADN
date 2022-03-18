package com.example.domain.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo


@Dao
interface VehiculoDao {
    @Insert
    fun insertVehiculo(vararg vehiculo: Vehiculo)

    @Delete
    suspend fun deleteVehiculo(vehiculo: Vehiculo)

    @Query("SELECT * FROM vehiculo")
    suspend fun getAllMotos(): List<Moto>

    @Query("SELECT * FROM vehiculo")
    suspend fun getAllCarros(): List<Carro>

    @Query("SELECT * FROM vehiculo")
    suspend fun getAllVehiculos(): List<Vehiculo>


}


