package com.example.domain.valueobject

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo

class Parqueadero : CobroServicio, Ingreso {

    private var tarifaTotal = 0
    private var hayCupo = false
    private var restringido = false
    var listaVehiculoCarro = ArrayList<Carro>()
    var listaVehiculoMoto = ArrayList<Moto>()
    private val diasPermitidos = arrayListOf("Domingo", "Lunes")

    override fun restriccionIngreso(vehiculo: Vehiculo, diaSemana: String): Boolean {

        restringido = false

        if (vehiculo.numeroPlaca.isEmpty()) {
            restringido = true

        } else {
            if (vehiculo.numeroPlaca.first() == LETRA_RESTRINGIDA) {
                restringido = !diasPermitidos.contains(diaSemana)
            }
        }
        return restringido
    }

    override fun ingresoVehiculos(vehiculo: Vehiculo, diaSemana: String): Boolean {

        var vehiculoIngresado = false
        when (vehiculo) {
            is Carro -> {
                val cuantosCarros = listaVehiculoCarro.size
                hayCupo = cuantosCarros <= LIMITE_CARRO
                if (restriccionIngreso(vehiculo, diaSemana) && hayCupo) {
                    listaVehiculoCarro.add(vehiculo)
                    vehiculoIngresado = true
                }
            }
            is Moto -> {
                val cuantasMotos = listaVehiculoMoto.size
                hayCupo = cuantasMotos <= LIMITE_MOTO
                if (restriccionIngreso(vehiculo, diaSemana) && hayCupo) {
                    listaVehiculoMoto.add(vehiculo)
                    vehiculoIngresado = true
                }
            }
            else -> {
                vehiculoIngresado = false
            }
        }

        return vehiculoIngresado
    }

    override fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int {
        when (vehiculo) {
            is Moto -> {
                if (listaVehiculoMoto.contains(vehiculo)) {
                    tarifaTotal = cobroTarifaMoto(duracionServicio, vehiculo)
                    listaVehiculoMoto.remove(vehiculo)
                }
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

        var tarifaParqueoTotal: Int
        //todo duracion de servicio < 0 retorne tal
        when (duracionServicio) {
            in 0..8 -> {
                tarifaParqueoTotal = duracionServicio * VALOR_HORA_MOTO
            }
            in 9..24 -> {
                tarifaParqueoTotal = VALOR_DIA_MOTO
            }
            else -> { // edge case
                val calculoCobro = (duracionServicio / HORAS_DIA).toString()
                var diasCobro = calculoCobro[0].toString().toInt()
                val diasEnHoras = diasCobro * HORAS_DIA
                var horasCobro = duracionServicio - diasEnHoras

                if (horasCobro >= 9) {
                    horasCobro = VALOR_DIA_MOTO
                } else {
                    horasCobro *= VALOR_HORA_MOTO
                }
                diasCobro *= VALOR_DIA_MOTO

                tarifaParqueoTotal = diasCobro + horasCobro
            }

        }
        if (moto.cilindrajeAlto) {
            tarifaParqueoTotal += COBRO_ALTO_CILINDRAJE
        }
        return tarifaParqueoTotal
    }

    override fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int {

        val tarifaParqueoTotal: Int

        when (duracionServicio) {
            in 0..8 -> {
                tarifaParqueoTotal = duracionServicio * VALOR_HORA_CARRO
            }
            in 9..25 -> {
                tarifaParqueoTotal = VALOR_DIA_CARRO
            }
            else -> {
                val calculoCobro = (duracionServicio / HORAS_DIA).toString()
                var diasCobro = calculoCobro[0].toString().toInt()
                val diasEnHoras = diasCobro * HORAS_DIA
                var horasCobro = duracionServicio - diasEnHoras

                if (horasCobro >= 9) {
                    horasCobro = VALOR_DIA_CARRO
                } else {
                    horasCobro *= VALOR_HORA_CARRO
                }
                diasCobro *= VALOR_DIA_CARRO


                tarifaParqueoTotal = diasCobro + horasCobro
            }
        }
        return tarifaParqueoTotal
    }

    companion object {

        const val LETRA_RESTRINGIDA = 'A'
        const val LIMITE_MOTO = 10
        const val LIMITE_CARRO = 20
        const val VALOR_HORA_MOTO = 500
        const val VALOR_DIA_MOTO = 4000
        const val VALOR_HORA_CARRO = 1000
        const val VALOR_DIA_CARRO = 8000
        const val COBRO_ALTO_CILINDRAJE = 2000
        const val HORAS_DIA = 24

    }
}