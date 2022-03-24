package com.example.insfrastructure.accesodatos.anticorrupcion

import com.example.dominio.vehiculo.modelo.Moto
import com.example.insfrastructure.accesodatos.entidadesbasedatos.EntidadDatosMoto

class TraductorMoto {

    fun DominioADtoMoto(moto: Moto): EntidadDatosMoto {
        return EntidadDatosMoto(moto.placaVehiculo, moto.cilindrajeAlto)
    }

}
