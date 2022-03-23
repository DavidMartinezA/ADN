package com.example.domain.objetoDeValor

import com.example.domain.entidad.Carro
import com.example.domain.entidad.Moto

interface CobroServicio { // todo segregacion de interfaces

    fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int

    fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int

}