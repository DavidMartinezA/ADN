package com.example.insfrastructure.accesodatos.anticorrupcion

import com.example.domain.entidad.Moto
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadDatosMoto

class MotoTranslator {

    fun fromDomainToDto(moto: Moto): EntidadDatosMoto {
        return EntidadDatosMoto(moto.identificacionVehiculo, moto.cilindrajeAlto)
    }

}