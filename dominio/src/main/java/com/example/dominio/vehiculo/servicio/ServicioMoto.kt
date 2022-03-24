package com.example.dominio.vehiculo.servicio

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo
import com.example.dominio.vehiculo.repositorio.RepositorioMoto

class ServicioMoto(var repositorioMoto: RepositorioMoto) : ServicioVehiculo() {
    companion object {
        const val CAPACIDAD_TOTAL_MOTOS = 10
    }

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
        val carroGuardado = if (repositorioMoto.motoExiste(vehiculo)) {
            false
            // todo ARROJAR UNA EXEPCION
        } else {
            repositorioMoto.eliminarMoto(vehiculo as Moto)
            true
        }
        return carroGuardado
    }

    override suspend fun consutarCapacidad(): Boolean {
        val listaMotos: ArrayList<Vehiculo> = repositorioMoto.listaMotos()
        val hayEspacioEnEstacionamiento = listaMotos.size <= CAPACIDAD_TOTAL_MOTOS
        return hayEspacioEnEstacionamiento
    }
}
