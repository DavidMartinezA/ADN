package com.example.domain.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.entity.Moto

@Dao
interface MotoDao {
    @Insert
    fun insertVehiculoMoto(vararg moto: Moto)

    @Delete
    suspend fun deleteVehiculoMoto(moto: Moto)

    @Query("SELECT * FROM Moto")
    suspend fun getAllMotos(): List<Moto>
}