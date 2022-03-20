package com.example.domain.aggregate

import com.example.domain.entity.Carro
import com.example.domain.entity.Moto
import com.example.domain.entity.Vehiculo
import com.example.domain.valueobject.CobroServicio
import com.example.domain.valueobject.Ingreso
import kotlin.math.ceil

class Parqueadero() : CobroServicio, Ingreso{

    var restringido = false
    private var listaVehiculo = arrayListOf<Vehiculo>()
    private val diasPermitidos = arrayListOf("Domingo", "Lunes")

    override fun restriccionIngreso(vehiculo: Vehiculo, diaSemana :String): Boolean {

        restringido = false

        if (vehiculo.numeroPlaca.isEmpty()) {
            restringido = true

        } else {
            vehiculo.numeroPlaca.uppercase()
            if (vehiculo.numeroPlaca.first().uppercase() == LETRA_RESTRINGIDA) {
                restringido = !diasPermitidos.contains(diaSemana)
                    /*val alertas = CreadorAlertas()
                     alertas.mostrarDialogoAlerta(context,"Error","Informacion NO Valida")*/
                }
        }
        return restringido
    }

    override fun ingresoVehiculos(vehiculo: Vehiculo, diaSemana :String ): Boolean {

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

        if (restriccionIngreso(vehiculo,diaSemana ) && hayCupo && !restringido){
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

    override fun salidaVehiculos(vehiculo: Vehiculo): Boolean {
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
