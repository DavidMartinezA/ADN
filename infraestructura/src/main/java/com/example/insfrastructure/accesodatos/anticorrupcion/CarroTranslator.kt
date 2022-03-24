package com.example.insfrastructure.accesodatos.anticorrupcion

import com.example.dominio.vehiculo.modelo.Carro
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadDatosCarro

class CarroTranslator {

    fun fromDomainToDto(carro: Carro): EntidadDatosCarro {
        return EntidadDatosCarro(carro.placaVehiculo)
    }

}