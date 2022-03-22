package com.example.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.entity.Moto

interface MotoDao {
    @Insert
    fun insertVehiculoMoto(vararg vehiculo: Moto)

    @Delete
    suspend fun deleteVehiculo(vehiculo: Moto)

    @Query("SELECT * FROM Moto")
    suspend fun getAllMotos(): List<Moto>
}