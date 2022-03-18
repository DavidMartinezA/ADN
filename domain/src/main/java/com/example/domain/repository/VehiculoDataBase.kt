package com.example.domain.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entity.Vehiculo

@Database(entities = [Vehiculo::class], version = 1)
abstract class VehiculoDataBase: RoomDatabase() {

    abstract fun userDao(): VehiculoDao
}