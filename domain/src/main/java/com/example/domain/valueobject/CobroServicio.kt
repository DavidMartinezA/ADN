package com.example.domain.valueobject

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import kotlin.math.ceil

interface CobroServicio {

    fun cobroTarifaMoto(duracionServicio: Double, moto: Moto): Int

    fun cobroTarifaCarro(duracionServicio: Double, carro: Carro): Int

}