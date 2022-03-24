package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo

class CobroTarifa(var duracionServicioEstacionamiento: Int, var vehiculo: Vehiculo) :
    CobroServicioCarro, CobroServicioMoto {

    private var tarifaTotal = 0
    private var tarifaParqueoTotal = 0

    companion object {

        const val VALOR_HORA_MOTO = 500
        const val VALOR_DIA_MOTO = 4000
        const val VALOR_HORA_CARRO = 1000
        const val VALOR_DIA_CARRO = 8000
        const val COBRO_ALTO_CILINDRAJE = 2000
        const val HORAS_EN_EL_DIA = 24

    }


    override fun cobroTarifaMoto(): Int {


        if (duracionServicioEstacionamiento > 0) {
            when (duracionServicioEstacionamiento) {
                in 0..8 -> {
                    tarifaParqueoTotal = duracionServicioEstacionamiento * VALOR_HORA_MOTO
                }
                in 9..24 -> {
                    tarifaParqueoTotal = VALOR_DIA_MOTO
                }
                in 25..216 -> {
                    val calculoCobro =
                        (duracionServicioEstacionamiento / HORAS_EN_EL_DIA).toString()
                    var diasCobro = calculoCobro[0].toString().toInt()
                    val diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    var horasCobro = duracionServicioEstacionamiento - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = VALOR_DIA_MOTO
                    } else {
                        horasCobro *= VALOR_HORA_MOTO
                    }
                    diasCobro *= VALOR_DIA_MOTO
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                in 217..999 -> {
                    val calculoCobro =
                        (duracionServicioEstacionamiento / HORAS_EN_EL_DIA).toString()
                    val diasCobroDecena = calculoCobro[0].toString()
                    val diasCobroUnidad = calculoCobro[1].toString()
                    var diasCobro = (diasCobroDecena + diasCobroUnidad).toInt()
                    val diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    var horasCobro = duracionServicioEstacionamiento - diasEnHoras

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
            if ((vehiculo as Moto).cilindrajeAlto) {
                tarifaParqueoTotal += COBRO_ALTO_CILINDRAJE
            }

        } else {
            tarifaParqueoTotal = 0

        }
        return tarifaParqueoTotal
    }

    override fun cobroTarifaCarro(): Int {

        if (duracionServicioEstacionamiento > 0) {
            when (duracionServicioEstacionamiento) {
                in 0..8 -> {
                    tarifaParqueoTotal = duracionServicioEstacionamiento * VALOR_HORA_CARRO
                }
                in 9..24 -> {
                    tarifaParqueoTotal = VALOR_DIA_CARRO
                }
                in 25..216 -> {
                    val calculoCobro =
                        (duracionServicioEstacionamiento / HORAS_EN_EL_DIA).toString()
                    var diasCobro = calculoCobro[0].toString().toInt()
                    val diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    var horasCobro = duracionServicioEstacionamiento - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = VALOR_DIA_CARRO
                    } else {
                        horasCobro *= VALOR_HORA_CARRO
                    }
                    diasCobro *= VALOR_DIA_CARRO
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                in 217..999 -> {
                    val calculoCobro =
                        (duracionServicioEstacionamiento / HORAS_EN_EL_DIA).toString()
                    val diasCobroDecena = calculoCobro[0].toString()
                    val diasCobroUnidad = calculoCobro[1].toString()
                    var diasCobro = (diasCobroDecena + diasCobroUnidad).toInt()
                    val diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    var horasCobro = duracionServicioEstacionamiento - diasEnHoras

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
