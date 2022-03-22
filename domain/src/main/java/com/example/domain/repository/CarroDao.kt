package com.example.domain.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.entity.Carro

@Dao
interface CarroDao {
    @Insert
    fun insertVehiculoCarro(vararg carro: Carro)

    @Delete
    suspend fun deleteVehiculoCarro(Carro: Carro)

    @Query("SELECT * FROM Carro")
    suspend fun getAllCarros(): List<Carro>

    /*   @Query("SELECT * FROM Carro")
       suspend fun getCarro(): List<Carro>*/


}


