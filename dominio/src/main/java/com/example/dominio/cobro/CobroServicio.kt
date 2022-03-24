package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Carro
import com.example.dominio.vehiculo.modelo.Moto

interface CobroServicio { // todo segregacion de interfaces

    fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int

    fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int

}