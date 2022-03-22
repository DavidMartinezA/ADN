package com.example.domain.entity

class Carro( numeroPlaca: String) : Vehiculo() {

    override var numeroPlaca = numeroPlaca.uppercase()

}