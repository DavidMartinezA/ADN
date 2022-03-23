package com.example.domain.entidad

class Moto(numeroPlaca: String, var cilindrajeAlto: Boolean = false) : Vehiculo() {
    override var identificacionVehiculo = numeroPlaca.uppercase().replace(" ", "")
}