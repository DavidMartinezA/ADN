package com.example.domain.entity

import androidx.room.PrimaryKey

class Carro( numeroPlaca: String) : Vehiculo() {


    @PrimaryKey override var numeroPlaca = numeroPlaca.uppercase()

    

}