package com.example.insfrastructure.accesodatos.repositorio

import com.example.dominio.modelo.Carro
import com.example.dominio.modelo.Moto
import com.example.dominio.modelo.Vehiculo
import com.example.dominio.repositorio.RepositorioVehiculo
import com.example.insfrastructure.accesodatos.anticorrupcion.CarroTranslator
import com.example.insfrastructure.accesodatos.anticorrupcion.MotoTranslator
import com.example.insfrastructure.accesodatos.basededatos.CarroDataBase
import com.example.insfrastructure.accesodatos.basededatos.MotoDataBase

class RepositorioVehiculoRoom(
    val carroDataBase: CarroDataBase,
    val motoDataBase: MotoDataBase,
) : RepositorioVehiculo {

    override suspend fun vehiculoExiste(vehiculo: Vehiculo): Boolean {

        return true
    }

    override suspend fun guardarMoto(moto: Moto) {
        val translation = MotoTranslator()
        val motoTranslation = translation.fromDomainToDto(moto)

        motoDataBase.motoDao().insertVehiculoMoto(motoTranslation)
    }

    override suspend fun guardarCarro(carro: Carro) {
        val translation = CarroTranslator()
        val carroTranslation = translation.fromDomainToDto(carro)

        carroDataBase.CarroDao().insertVehiculoCarro(carroTranslation)

    }

    override suspend fun eliminarVehiculo(vehiculo: Vehiculo) {

    }
}
