package com.example.dominio.vehiculo.modelo

class Carro(override var placaVehiculo: String) : Vehiculo(placaVehiculo) {

    init {
        if (placaVehiculo.isEmpty() || !placaVehiculo.matches(Regex(FORMATO_PLACA))) {
            throw throw Exception(MENSAJE_EXEPCION_NO_AUTORIZADO)
        }
    }
}


