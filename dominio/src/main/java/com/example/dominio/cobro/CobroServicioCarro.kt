package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Carro


interface CobroServicioCarro {

    fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int

}