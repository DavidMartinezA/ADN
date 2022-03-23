package com.example.insfrastructure.accesodatos.basededatos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.insfrastructure.accesodatos.CarroDao
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadDatosCarro

@Database(entities = [EntidadDatosCarro::class], version = 1, exportSchema = false)
abstract class CarroDataBase : RoomDatabase() {

    abstract fun CarroDao(): CarroDao

}