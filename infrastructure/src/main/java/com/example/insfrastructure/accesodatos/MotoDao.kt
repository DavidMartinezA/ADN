package com.example.insfrastructure.accesodatos

import androidx.room.*
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadBaseDatosMoto

@Dao
interface MotoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVehiculoMoto(moto: com.example.domain.entity.Moto)

    @Delete
    suspend fun deleteVehiculoMoto(moto: EntidadBaseDatosMoto)

    @Query("SELECT * FROM EntidadBaseDatosMoto")
    suspend fun getAllMotos(): List<EntidadBaseDatosMoto>
}