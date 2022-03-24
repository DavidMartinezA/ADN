package com.example.dominio.vehiculo.servicio

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.repositorio.RepositorioMoto

class ServicioMoto(private var repositorioMoto: RepositorioMoto) : ServicioVehiculo() {

    override suspend fun guardar(vehiculo: Vehiculo): Boolean {
        val motoGuardada = if (repositorioMoto.motoExiste(vehiculo)) {
            false
            // todo ARROJAR UNA EXEPCION
        } else {
            repositorioMoto.guardarMoto(vehiculo as Moto)
            true
        }
        return motoGuardada
    }

    override suspend fun eliminar(vehiculo: Vehiculo): Boolean {
        val motoBorrada = if (repositorioMoto.motoExiste(vehiculo)) {
            false
            // todo ARROJAR UNA EXEPCION
        } else {
            repositorioMoto.eliminarMoto(vehiculo as Moto)
            true
        }
        return motoBorrada
    }

    override suspend fun consultarLista(): ArrayList<Vehiculo> {
        return repositorioMoto.listaMotos()
    }

}
