package com.example.insfrastructure

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entity.Vehiculo
import com.example.domain.repository.CarroDao
import com.example.domain.repository.MotoDao

@Database(entities = [Vehiculo::class], version = 1)
abstract class VehiculoDataBase: RoomDatabase() {

    abstract fun CarroDao(): CarroDao
    abstract fun MotoDao(): MotoDao

}