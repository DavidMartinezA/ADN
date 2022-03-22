package com.example.insfrastructure.accesodatos.basededatos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.insfrastructure.accesodatos.CarroDao
import com.example.insfrastructure.accesodatos.dto.CarroDto

@Database(entities = [CarroDto::class], version = 1)
abstract class CarroDataBase : RoomDatabase() {

    abstract fun CarroDao(): CarroDao

}