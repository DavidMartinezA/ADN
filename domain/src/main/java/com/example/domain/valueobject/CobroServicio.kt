package com.example.domain.valueobject

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto

interface CobroServicio {

    fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int

    fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int

}