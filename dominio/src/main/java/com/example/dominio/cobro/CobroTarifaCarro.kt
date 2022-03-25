package com.example.dominio.cobro

import com.example.dominio.vehiculo.modelo.Vehiculo

class CobroTarifaCarro(
    override var duracionServicioEstacionamiento: Int,
    override var vehiculo: Vehiculo,
) : CobroTarifa(duracionServicioEstacionamiento, vehiculo) {

    override var valorHora = 1000
    override var valorDia = 8000
    override var tarifaParqueoTotal = 0
    private val calculoCobro = (duracionServicioEstacionamiento / HORAS_EN_EL_DIA).toString()
    private var diasCobro = 0
    private var diasEnHoras = 0
    private var horasCobro = 0

    override fun cobroTarifa(): Int {
        if (duracionServicioEstacionamiento > 0) {
            when (duracionServicioEstacionamiento) {
                in 0..8 -> {
                    tarifaParqueoTotal = duracionServicioEstacionamiento * valorHora
                }
                in 9..24 -> {
                    tarifaParqueoTotal = valorDia
                }
                in 25..216 -> {
                    diasCobro = calculoCobro[0].toString().toInt()
                    diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    horasCobro = duracionServicioEstacionamiento - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = valorDia
                    } else {
                        horasCobro *= valorHora
                    }
                    diasCobro *= valorDia
                    tarifaParqueoTotal = diasCobro + horasCobro
                }
                in 217..2376 -> {
                    val diasCobroDecena = calculoCobro[0].toString()
                    val diasCobroUnidad = calculoCobro[1].toString()
                    diasCobro = (diasCobroDecena + diasCobroUnidad).toInt()
                    diasEnHoras = diasCobro * HORAS_EN_EL_DIA
                    horasCobro = duracionServicioEstacionamiento - diasEnHoras

                    if (horasCobro >= 9) {
                        horasCobro = valorDia
                    } else {
                        horasCobro *= valorHora
                    }
                    diasCobro *= valorDia
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
