package com.example.insfrastructure.accesodatos.anticorrupcion

import com.example.domain.entity.Moto
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadDatosMoto

class MotoTranslator {

    fun fromDomainToDto(moto: Moto): EntidadDatosMoto {
        return EntidadDatosMoto(moto.numeroPlaca, moto.cilindrajeAlto)
    }

}