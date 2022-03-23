package com.example.insfrastructure.accesodatos.anticorrupcion

import com.example.domain.entity.Moto
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadBaseDatosMoto

class MotoTranslator {

    fun fromDomainToDto(moto: Moto): EntidadBaseDatosMoto {
        return EntidadBaseDatosMoto(moto.numeroPlaca, moto.cilindrajeAlto)
    }

}