package com.example.insfrastructure.accesodatos.basededatos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.insfrastructure.accesodatos.MotoDao
import com.example.insfrastructure.accesodatos.dto.MotoDto

@Database(entities = [MotoDto::class], version = 1)
abstract class MotoDataBase : RoomDatabase() {

    abstract fun MotoDao(): MotoDao

}