package com.example.dominio.vehiculo.servicio

import com.example.dominio.vehiculo.modelo.Carro
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.repositorio.RepositorioCarro

class ServicioCarro(var repositorioCarro: RepositorioCarro) : ServicioVehiculo() {

    companion object {
        const val CAPACIDAD_TOTAL_CARROS = 20
    }

    override suspend fun guardar(vehiculo: Vehiculo): Boolean {
        val carroGuardado = if (repositorioCarro.carroExiste(vehiculo)) {
            false
            // todo ARROJAR UNA EXEPCION
        } else {
            repositorioCarro.guardarCarro(vehiculo as Carro)
            true
        }
        return carroGuardado
    }

    override suspend fun eliminar(vehiculo: Vehiculo): Boolean {
        val carroGuardado = if (repositorioCarro.carroExiste(vehiculo)) {
            false
            // todo ARROJAR UNA EXEPCION
        } else {
            repositorioCarro.eliminarCarro(vehiculo as Carro)
            true
        }
        return carroGuardado
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaCarros: ArrayList<Vehiculo> = repositorioCarro.listaCarros()
        val hayEspacioEnEstacionamiento = listaCarros.size <= CAPACIDAD_TOTAL_CARROS
        return hayEspacioEnEstacionamiento
    }
}