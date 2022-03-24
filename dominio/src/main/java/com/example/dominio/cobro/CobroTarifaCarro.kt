package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Vehiculo

class CobroTarifaCarro(
    duracionServicioEstacionamiento: Int,
    override var vehiculo: Vehiculo,
) : CobroTarifa(duracionServicioEstacionamiento, vehiculo) {

    companion object {
        const val VALOR_HORA_CARRO = 1000
        const val VALOR_DIA_CARRO = 8000
    }

    private val calculoCobro = (duracionServicioEstacionamiento / HORAS_EN_EL_DIA).toString()

    override fun cobroTarifa(): Int {
        if (duracionServicioEstacionamiento > 0) {
            when (duracionServicioEstacionamiento) {
                in 0..8 -> {
                    tarifaParqueoTotal = duracionServicioEstacionamiento * VALOR_HORA_CARRO
                }
                in 9..24 -> {
                    tarifaParqueoTotal = VALOR_DIA_CARRO
                }
                in 25..216 -> {
                    diasCobro = calculoCobro[0].toString().toInt()
                    diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    horasCobro = duracionServicioEstacionamiento - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = VALOR_DIA_CARRO
                    } else {
                        horasCobro *= VALOR_HORA_CARRO
                    }
                    diasCobro *= VALOR_DIA_CARRO
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                in 217..999 -> {
                    val diasCobroDecena = calculoCobro[0].toString()
                    val diasCobroUnidad = calculoCobro[1].toString()
                    diasCobro = (diasCobroDecena + diasCobroUnidad).toInt()
                    diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    horasCobro = duracionServicioEstacionamiento - diasEnHoras

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
        }
        return tarifaParqueoTotal
    }

}