package com.example.dominio.vehiculo.modelo

class Moto(override var placaVehiculo: String, val cilindrajeAlto: Boolean = false) :
    Vehiculo(placaVehiculo) {

    init {
        if (placaVehiculo.isEmpty() || !placaVehiculo.matches(Regex(FORMATO_PLACA))) {
            throw throw Exception(MENSAJE_EXEPCION_NO_AUTORIZADO)
        }
    }

}