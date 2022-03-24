package com.example.dominio.vehiculo.modelo

class Carro(override val placaVehiculo: String) : Vehiculo(placaVehiculo) {
    //[a-zA-Z]{3}-?[0-9]{2}[a-zA-Z0-9]?

}