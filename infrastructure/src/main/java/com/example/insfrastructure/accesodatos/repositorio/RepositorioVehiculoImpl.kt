package com.example.insfrastructure.accesodatos.repositorio

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo
import com.example.domain.repository.RepositorioVehiculo
import com.example.insfrastructure.accesodatos.basededatos.CarroDataBase
import com.example.insfrastructure.accesodatos.basededatos.MotoDataBase

class RepositorioVehiculoImpl(
    val carroDataBase: CarroDataBase,
    val motoDataBase: MotoDataBase,
) : RepositorioVehiculo {

    override suspend fun vehiculoExiste(vehiculo: Vehiculo): Boolean {

        return true
    }

    override suspend fun guardarMoto(moto: Moto) {
        motoDataBase.motoDao().insertVehiculoMoto(moto)
    }

    override suspend fun guardarCarro(carro: Carro) {

    }

    override suspend fun eliminarVehiculo(vehiculo: Vehiculo) {

    }
}
