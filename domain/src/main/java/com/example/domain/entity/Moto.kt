package com.example.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Moto( numeroPlaca: String, var cilindrajeAlto: Boolean = false) : Vehiculo() {

    @PrimaryKey override var numeroPlaca = numeroPlaca.uppercase()
}