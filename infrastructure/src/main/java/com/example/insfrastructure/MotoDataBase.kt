package com.example.insfrastructure

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entity.Moto
import com.example.domain.repository.MotoDao

@Database(entities = [Moto::class], version = 1)
abstract class MotoDataBase : RoomDatabase() {

    abstract fun MotoDao(): MotoDao

}