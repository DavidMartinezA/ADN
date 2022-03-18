package com.example.domain.entity

import androidx.room.PrimaryKey

class Moto(@PrimaryKey override var numeroPlaca: String, var cilindrajeAlto: Boolean = false) : Vehiculo() {

}