package com.example.domain.entity

class Moto( numeroPlaca: String, var cilindrajeAlto: Boolean = false) : Vehiculo() {
    override var numeroPlaca = numeroPlaca.uppercase().replace(" ", "")
}