package com.example.domain.valueobject

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo
import kotlin.math.ceil

class Parqueadero() : CobroServicio {

    var restringido = false
    private var listaVehiculo = arrayListOf<Vehiculo>()
    private val diasPermitidos = arrayListOf("Domingo", "Lunes")

    private fun restriccionIngreso(vehiculo: Vehiculo, diaDeLaSemana: String): Boolean {

        restringido = false

        if (vehiculo.numeroPlaca.isEmpty()) {
            restringido = true
            /*val alertas = CreadorAlertas()
            alertas.mostrarDialogoAlerta(context,"Error","Informacion NO Valida")*/
        } else {
            vehiculo.numeroPlaca.uppercase()
            if (vehiculo.numeroPlaca.first().uppercase() == LETRA_RESTRINGIDA) {
                restringido = !diasPermitidos.contains(diaDeLaSemana)
            }
        }
        return restringido
    }

    fun ingresoVehiculos(vehiculo: Vehiculo, diaDeLaSemana: String): Boolean {

        var hayCupo = false

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

        if (restriccionIngreso(vehiculo, diaDeLaSemana) && hayCupo) {
            listaVehiculo.add(vehiculo)
        }
        return hayCupo
    }

    override fun cobroTarifaMoto(duracionServicio: Double, moto: Moto): Int {

        var tarifaParqueoTotal: Int = if (duracionServicio < 9) {
            duracionServicio.toInt() * VALOR_HORA_MOTO
        } else {
            ((duracionServicio / 24) * VALOR_DIA_MOTO).toInt()

        }
        if (moto.cilindrajeAlto) {
            tarifaParqueoTotal += 2000
        }
        return tarifaParqueoTotal
    }

    override fun cobroTarifaCarro(duracionServicio: Double, carro: Carro): Int {

        val fraccionDias = 24.0 / duracionServicio
        ceil(fraccionDias)

        val tarifaParqueoTotal: Int = if (duracionServicio < 9) {
            duracionServicio.toInt() * VALOR_HORA_CARRO
        } else {
            (fraccionDias * VALOR_DIA_CARRO).toInt()
        }
        return tarifaParqueoTotal
    }

    fun salidaVehiculos(vehiculo: Vehiculo): Boolean {
        listaVehiculo.remove(vehiculo)
        return true
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
