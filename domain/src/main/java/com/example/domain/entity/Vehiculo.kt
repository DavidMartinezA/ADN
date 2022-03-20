package com.example.domain.entity

import androidx.room.Entity

@Entity
abstract class Vehiculo() {
   abstract val numeroPlaca: String

}