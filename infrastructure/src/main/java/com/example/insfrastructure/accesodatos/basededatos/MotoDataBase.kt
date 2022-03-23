package com.example.insfrastructure.accesodatos.basededatos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.insfrastructure.accesodatos.MotoDao
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadDatosMoto

@Database(entities = [EntidadDatosMoto::class], version = 1, exportSchema = false)
abstract class MotoDataBase : RoomDatabase() {

    abstract fun motoDao(): MotoDao

}