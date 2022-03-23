package com.example.insfrastructure.accesodatos.anticorrupcion

import com.example.domain.entity.Carro
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadBaseDatosCarro

class CarroTranslator {

    fun fromDomainToDto(carro: Carro): EntidadBaseDatosCarro {
        return EntidadBaseDatosCarro(carro.numeroPlaca)
    }

}