package com.example.domain.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.entity.Carro

@Dao
interface CarroDao {
    @Insert
    fun insertVehiculo(vararg vehiculo: Carro)

    @Delete
    suspend fun deleteVehiculo(vehiculo: Carro)

    @Query("SELECT * FROM Carro")
    suspend fun getAllCarros(): List<Carro>

    /*   @Query("SELECT * FROM Carro")
       suspend fun getCarro(): List<Carro>*/


}


