package com.example.dominio.modelo

interface CobroServicio { // todo segregacion de interfaces

    fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int

    fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int

}