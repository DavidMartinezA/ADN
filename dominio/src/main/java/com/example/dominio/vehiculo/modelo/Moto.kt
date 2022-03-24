package com.example.dominio.vehiculo.modelo

class Moto(override var placaVehiculo: String, var cilindrajeAlto: Boolean = false) :
    Vehiculo(placaVehiculo) {

    //Patter p= [a-zA-Z]{3}-?\d{2}[a-zA-Z|0-9]?

}