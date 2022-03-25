package com.example.dominio.vehiculo.modelo


abstract class Vehiculo(val placaVehiculo: String) {

    companion object {
        const val FORMATO_PLACA = "[a-zA-Z]{3}-?[0-9]{2}[a-zA-Z0-9]?"
    }

    val mensajeNoEstaAutorizado = "No Esta Autorizado Ingresar."
    lateinit var campoVacio: String

    init {
        if (placaVehiculo.isEmpty() || !placaVehiculo.matches(Regex(FORMATO_PLACA))) {
            campoVacio = mensajeNoEstaAutorizado
        }
    }
}
