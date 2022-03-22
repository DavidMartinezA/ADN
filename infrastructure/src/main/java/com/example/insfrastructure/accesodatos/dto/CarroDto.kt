package com.example.insfrastructure.accesodatos.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CarroDto {

    @PrimaryKey
    private lateinit var numeroPlaca: String


    fun IngresarNumeroPlaca(numeroPlaca: String) {
        this.numeroPlaca = numeroPlaca
    }
}