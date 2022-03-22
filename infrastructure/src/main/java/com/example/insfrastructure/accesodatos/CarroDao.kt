package com.example.insfrastructure.accesodatos

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

    @Query("SELECT * FROM CarroDto")
    suspend fun getAllCarros(): List<Carro>


}


