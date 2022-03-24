package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Moto
import com.example.dominio.vehiculo.modelo.Vehiculo

class CobroTarifaMoto(
    override var duracionServicioEstacionamiento: Int,
    override var vehiculo: Vehiculo,
) : CobroTarifa(duracionServicioEstacionamiento, vehiculo) {

    companion object {
        const val VALOR_HORA_MOTO = 500
        const val VALOR_DIA_MOTO = 4000
        const val COBRO_ALTO_CILINDRAJE = 2000
    }

    val calculoCobro = (duracionServicioEstacionamiento / HORAS_EN_EL_DIA).toString()

    override fun cobroTarifa(): Int {
        if (duracionServicioEstacionamiento > 0) {
            when (duracionServicioEstacionamiento) {
                in 0..8 -> {
                    tarifaParqueoTotal = duracionServicioEstacionamiento * VALOR_HORA_MOTO
                }
                in 9..24 -> {
                    tarifaParqueoTotal = VALOR_DIA_MOTO
                }
                in 25..216 -> {
                    diasCobro = calculoCobro[0].toString().toInt()
                    diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    horasCobro = duracionServicioEstacionamiento - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = VALOR_DIA_MOTO
                    } else {
                        horasCobro *= VALOR_HORA_MOTO
                    }
                    diasCobro *= VALOR_DIA_MOTO
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                in 217..999 -> {
                    val diasCobroDecena = calculoCobro[0].toString()
                    val diasCobroUnidad = calculoCobro[1].toString()
                    diasCobro = (diasCobroDecena + diasCobroUnidad).toInt()
                    diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    horasCobro = duracionServicioEstacionamiento - diasEnHoras

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
            return tarifaParqueoTotal

        }
        if ((vehiculo as Moto).cilindrajeAlto) {
            tarifaParqueoTotal += COBRO_ALTO_CILINDRAJE
        } else {
            tarifaParqueoTotal = 0
        }
        return tarifaParqueoTotal
    }
}



