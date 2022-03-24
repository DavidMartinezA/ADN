package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Moto


interface CobroServicioMoto {

    fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int
}