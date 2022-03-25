package com.example.dominio.vehiculo.modelo


abstract class Vehiculo(val placaVehiculo: String) {

    companion object {
        const val FORMATO_PLACA = "[a-zA-Z]{3}-?[0-9]{2}[a-zA-Z0-9]?"
    }

    init {

        var validado = false
        fun validacion(): Boolean {
            if (placaVehiculo.isNotEmpty() || placaVehiculo.matches(Regex(FORMATO_PLACA))) {
                validado = true
            }
            return validado
        }
    }

}
