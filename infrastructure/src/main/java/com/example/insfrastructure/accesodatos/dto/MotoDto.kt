package com.example.insfrastructure.accesodatos.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.properties.Delegates

@Entity
class MotoDto {

    @PrimaryKey
    private lateinit var numeroPlaca: String
    private var cilindrajeAlto by Delegates.notNull<Boolean>()

    fun IngresarNumeroPlaca(numeroPlaca: String) {
        this.numeroPlaca = numeroPlaca
    }

    fun IngresarCilindrajeAlto(cilindrajeAlto: Boolean) {
        this.cilindrajeAlto = cilindrajeAlto
    }
}