package com.example.insfrastructure.accesodatos.basededatos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entity.Moto
import com.example.insfrastructure.accesodatos.MotoDao

@Database(entities = [Moto::class], version = 1)
abstract class MotoDataBase : RoomDatabase() {

    abstract fun MotoDao(): MotoDao

}