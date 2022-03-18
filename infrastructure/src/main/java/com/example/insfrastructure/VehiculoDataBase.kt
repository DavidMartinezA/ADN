package com.example.insfrastructure

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entity.Vehiculo
import com.example.domain.repository.VehiculoDao

@Database(entities = [Vehiculo::class], version = 1)
abstract class VehiculoDataBase: RoomDatabase() {

    abstract fun userDao(): VehiculoDao
}