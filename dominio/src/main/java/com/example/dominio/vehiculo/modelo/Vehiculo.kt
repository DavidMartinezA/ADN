package com.example.dominio.vehiculo.modelo

abstract class Vehiculo(open var placaVehiculo: String) {
    companion object {
        const val FORMATO_PLACA = "[a-zA-Z]{3}-?[0-9]{2}[a-zA-Z0-9]?"
        const val MENSAJE_EXEPCION_NO_AUTORIZADO = "No Esta Autorizado Ingresar."
    }
}