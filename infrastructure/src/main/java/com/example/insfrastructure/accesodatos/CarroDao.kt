package com.example.insfrastructure.accesodatos

import androidx.room.*
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadBaseDatosCarro

@Dao
interface CarroDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVehiculoCarro(carro: EntidadBaseDatosCarro)

    @Delete
    suspend fun deleteVehiculoCarro(carro: EntidadBaseDatosCarro)

    @Query("SELECT * FROM EntidadBaseDatosCarro")
    suspend fun getAllCarros(): List<EntidadBaseDatosCarro>


}


