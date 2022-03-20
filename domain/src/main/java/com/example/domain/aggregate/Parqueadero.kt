package com.example.domain.aggregate

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo
import com.example.domain.valueobject.CobroServicio
import com.example.domain.valueobject.Ingreso

class Parqueadero : CobroServicio, Ingreso {

    private var tarifaTotal = 0
    private var hayCupo = false
    private var restringido = false
    private var listaVehiculo = arrayListOf<Vehiculo>()
    private val diasPermitidos = arrayListOf("Domingo", "Lunes")

    override fun restriccionIngreso(vehiculo: Vehiculo, diaSemana: String): Boolean {

        restringido = false

        if (vehiculo.numeroPlaca.isEmpty()) {
            restringido = true

        } else {
            vehiculo.numeroPlaca.uppercase()
            if (vehiculo.numeroPlaca.first().uppercase() == LETRA_RESTRINGIDA) {
                restringido = !diasPermitidos.contains(diaSemana)
            }
        }
        return restringido
    }

    override fun ingresoVehiculos(vehiculo: Vehiculo, diaSemana: String): Boolean {

        var vehiculoIngresado = false
        when (vehiculo) {
            is Carro -> {
                val cuantosCarros = listaVehiculo.filterIsInstance<Carro>().size
                hayCupo = cuantosCarros <= LIMITE_CARRO
            }
            is Moto -> {
                val cuantasMotos = listaVehiculo.filterIsInstance<Moto>().size
                hayCupo = cuantasMotos <= LIMITE_MOTO
            }
        }

        if (restriccionIngreso(vehiculo, diaSemana) && hayCupo) {
            listaVehiculo.add(vehiculo)
            vehiculoIngresado = true
        }

        return vehiculoIngresado
    }

    override fun salidaVehiculos(vehiculo: Vehiculo, duracionServicio: Int): Int {


        if (listaVehiculo.contains(vehiculo)) {

            tarifaTotal = when (vehiculo) {
                is Moto -> {
                    cobroTarifaMoto(duracionServicio, vehiculo)
                }
                is Carro -> {
                    cobroTarifaCarro(duracionServicio, vehiculo)
                }
                else -> {
                    0
                }
            }
            listaVehiculo.remove(vehiculo)

        } else {
            tarifaTotal = 0

        }

        return tarifaTotal
    }

    override fun cobroTarifaMoto(duracionServicio: Int, moto: Moto): Int {

        var tarifaParqueoTotal: Int

        when (duracionServicio) {
            in 0..9 -> {
                tarifaParqueoTotal = duracionServicio * VALOR_HORA_MOTO
            }
            in 9..24 -> {
                tarifaParqueoTotal = VALOR_DIA_MOTO
            }
            else -> {
                val calculoCobro = (duracionServicio / 24.0).toString()
                var diasCobro = calculoCobro[0].toInt()
                var horasCobro = calculoCobro[2].toInt()
                diasCobro *= VALOR_DIA_MOTO
                horasCobro *= VALOR_HORA_MOTO

                tarifaParqueoTotal = diasCobro + horasCobro
            }

        }
        if (moto.cilindrajeAlto) {
            tarifaParqueoTotal += 2000
        }
        return tarifaParqueoTotal
    }

    override fun cobroTarifaCarro(duracionServicio: Int, carro: Carro): Int {

        val tarifaParqueoTotal: Int

        when (duracionServicio) {
            in 0..9 -> {
                tarifaParqueoTotal = duracionServicio * VALOR_HORA_CARRO
            }
            in 9..24 -> {
                tarifaParqueoTotal = VALOR_DIA_CARRO
            }
            else -> {
                val calculoCobro = (duracionServicio / 24.0).toString()
                var diasCobro = calculoCobro[0].toInt()
                var horasCobro = calculoCobro[2].toInt()
                diasCobro *= VALOR_DIA_CARRO
                horasCobro *= VALOR_HORA_CARRO

                tarifaParqueoTotal = diasCobro + horasCobro
            }
        }
        return tarifaParqueoTotal
    }

    companion object {

        const val LETRA_RESTRINGIDA = "A"
        const val LIMITE_MOTO = 10
        const val LIMITE_CARRO = 20
        const val VALOR_HORA_MOTO = 500
        const val VALOR_DIA_MOTO = 4000
        const val VALOR_HORA_CARRO = 1000
        const val VALOR_DIA_CARRO = 8000

    }
}
