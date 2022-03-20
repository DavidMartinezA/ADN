package com.example.domain.entity

import androidx.room.PrimaryKey

class Moto( numeroPlaca: String, var cilindrajeAlto: Boolean = false) : Vehiculo() {

    @PrimaryKey override var numeroPlaca = numeroPlaca.uppercase()
}