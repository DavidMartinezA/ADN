package com.example.domain.entity

import androidx.room.PrimaryKey

class Carro(@PrimaryKey override var numeroPlaca: String) : Vehiculo() {

}