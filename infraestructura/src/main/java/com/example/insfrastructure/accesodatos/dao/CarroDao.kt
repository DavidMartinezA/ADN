package com.example.insfrastructure.accesodatos.dao

import androidx.room.*
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadDatosCarro

@Dao
interface CarroDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVehiculoCarro(carro: EntidadDatosCarro)

    @Delete
    suspend fun deleteVehiculoCarro(carro: EntidadDatosCarro)

    @Query("SELECT * FROM EntidadDatosCarro")
    suspend fun getAllCarros(): List<EntidadDatosCarro>


}


