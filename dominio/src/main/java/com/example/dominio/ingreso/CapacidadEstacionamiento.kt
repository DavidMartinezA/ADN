package com.example.dominio.ingreso

import com.example.dominio.cobro.CobroServicio
import com.example.dominio.vehiculo.modelo.Carro
import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo

class CapacidadEstacionamiento : CobroServicio {// todo responsabilidad unica

    private var tarifaTotal = 0
    private var tarifaParqueoTotal = 0
    private var hayCupo = false
    private var restringido = false
    var listaVehiculoCarro =
        ArrayList<Carro>()// todo listas desconocidas (usar invercion de dependencias )
    var listaVehiculoMoto = ArrayList<Moto>()
    private val diasPermitidos = arrayListOf("Domingo", "Lunes")

    companion object {

        const val LETRA_RESTRINGIDA = 'A'
        const val LIMITE_MOTO = 10
        const val LIMITE_CARRO = 20
        const val VALOR_HORA_MOTO = 500
        const val VALOR_DIA_MOTO = 4000
        const val VALOR_HORA_CARRO = 1000
        const val VALOR_DIA_CARRO = 8000
        const val COBRO_ALTO_CILINDRAJE = 2000
        const val HORAS_EN_EL_DIA = 24

    }


    override fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int {
        when (vehiculo) {
            is Moto -> {

            }
            is Carro -> {
                if (listaVehiculoCarro.contains(vehiculo)) {
                    tarifaTotal = cobroTarifaCarro(duracionServicio, vehiculo)
                    listaVehiculoCarro.remove(vehiculo)
                }
            }
            else -> {
                tarifaTotal = 0
            }
        }
        return tarifaTotal
    }

    override fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int {

        if (duracionServicio > 0) {
            when (duracionServicio) {
                in 0..8 -> {
                    tarifaParqueoTotal = duracionServicio * VALOR_HORA_MOTO
                }
                in 9..24 -> {
                    tarifaParqueoTotal = VALOR_DIA_MOTO
                }
                in 25..216 -> {
                    val calculoCobro = (duracionServicio / HORAS_EN_EL_DIA).toString()
                    var diasCobro = calculoCobro[0].toString().toInt()
                    val diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    var horasCobro = duracionServicio - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = VALOR_DIA_MOTO
                    } else {
                        horasCobro *= VALOR_HORA_MOTO
                    }
                    diasCobro *= VALOR_DIA_MOTO
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                in 217..999 -> {
                    val calculoCobro = (duracionServicio / HORAS_EN_EL_DIA).toString()
                    val diasCobroDecena = calculoCobro[0].toString()
                    val diasCobroUnidad = calculoCobro[1].toString()
                    var diasCobro = (diasCobroDecena + diasCobroUnidad).toInt()
                    val diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    var horasCobro = duracionServicio - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = VALOR_DIA_MOTO
                    } else {
                        horasCobro *= VALOR_HORA_MOTO
                    }
                    diasCobro *= VALOR_DIA_MOTO
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                else -> { //Edge Case
                    tarifaParqueoTotal = 0
                }
            }
            if (moto.cilindrajeAlto) {
                tarifaParqueoTotal += COBRO_ALTO_CILINDRAJE
            }

        } else {
            tarifaParqueoTotal = 0

        }
        return tarifaParqueoTotal
    }

    override fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int {

        if (duracionServicio > 0) {
            when (duracionServicio) {
                in 0..8 -> {
                    tarifaParqueoTotal = duracionServicio * VALOR_HORA_CARRO
                }
                in 9..24 -> {
                    tarifaParqueoTotal = VALOR_DIA_CARRO
                }
                in 25..216 -> {
                    val calculoCobro = (duracionServicio / HORAS_EN_EL_DIA).toString()
                    var diasCobro = calculoCobro[0].toString().toInt()
                    val diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    var horasCobro = duracionServicio - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = VALOR_DIA_CARRO
                    } else {
                        horasCobro *= VALOR_HORA_CARRO
                    }
                    diasCobro *= VALOR_DIA_CARRO
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                in 217..999 -> {
                    val calculoCobro = (duracionServicio / HORAS_EN_EL_DIA).toString()
                    val diasCobroDecena = calculoCobro[0].toString()
                    val diasCobroUnidad = calculoCobro[1].toString()
                    var diasCobro = (diasCobroDecena + diasCobroUnidad).toInt()
                    val diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    var horasCobro = duracionServicio - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = VALOR_DIA_CARRO
                    } else {
                        horasCobro *= VALOR_HORA_CARRO
                    }
                    diasCobro *= VALOR_DIA_CARRO
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                else -> { //Edge Case
                    tarifaParqueoTotal = 0
                }
            }

        } else {
            tarifaParqueoTotal = 0
        }
        return tarifaParqueoTotal
    }

}
