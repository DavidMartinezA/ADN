package com.example.dominio.vehiculo.servicio

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.repositorio.RepositorioMoto

class ServicioMoto(private var repositorioMoto: RepositorioMoto, var moto: Moto) :
    ServicioVehiculo() {

    override suspend fun guardar(): Boolean {
        val motoGuardada = if (repositorioMoto.motoExiste(moto)) {
            false
        } else {
            repositorioMoto.guardarMoto(moto)
            true
        }
        return motoGuardada
    }

    override suspend fun eliminar(): Boolean {
        val motoBorrada = if (repositorioMoto.motoExiste(moto)) {
            false
        } else {
            repositorioMoto.eliminarMoto(moto)
            true
        }
        return motoBorrada
    }

    override suspend fun consultarLista(): ArrayList<Vehiculo> {
        return repositorioMoto.listaMotos()
    }
}

