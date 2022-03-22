package com.example.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Carro( numeroPlaca: String) : Vehiculo() {


    @PrimaryKey override var numeroPlaca = numeroPlaca.uppercase()


}