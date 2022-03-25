package com.example.dominio.vehiculo.servicio

import com.example.dominio.vehiculo.modelo.Carro
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.repositorio.RepositorioCarro

class ServicioCarro(var repositorioCarro: RepositorioCarro, var carro: Carro) : ServicioVehiculo() {

    override suspend fun guardar(): Boolean {
        val carroGuardado = if (repositorioCarro.carroExiste(carro)) {
            false
        } else {
            repositorioCarro.guardarCarro(carro)
            true
        }
        return carroGuardado
    }

    override suspend fun eliminar(): Boolean {
        val carroEliminado = if (repositorioCarro.carroExiste(carro)) {
            false
        } else {
            repositorioCarro.eliminarCarro(carro)
            true
        }
        return carroEliminado
    }

    override suspend fun consultarLista(): ArrayList<Vehiculo> {
        return repositorioCarro.listaCarros()
    }
}
