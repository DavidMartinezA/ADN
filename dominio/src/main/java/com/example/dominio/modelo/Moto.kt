package com.example.dominio.modelo

class Moto(numeroPlaca: String, var cilindrajeAlto: Boolean = false) : Vehiculo() {
    override var identificacionVehiculo = numeroPlaca.uppercase().replace(" ", "")
}