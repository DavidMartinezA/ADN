package com.example.insfrastructure

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entity.Carro
import com.example.domain.repository.CarroDao

@Database(entities = [Carro::class], version = 1)
abstract class CarroDataBase : RoomDatabase() {

    abstract fun CarroDao(): CarroDao

}