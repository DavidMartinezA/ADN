package com.example.insfrastructure.accesodatos.dao

import androidx.room.*
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadDatosMoto

@Dao
interface MotoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVehiculoMoto(moto: EntidadDatosMoto)

    @Delete
    suspend fun deleteVehiculoMoto(moto: EntidadDatosMoto)

    @Query("SELECT * FROM EntidadDatosMoto")
    suspend fun getAllMotos(): List<EntidadDatosMoto>
}