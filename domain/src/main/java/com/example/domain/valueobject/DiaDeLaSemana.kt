package com.example.domain.valueobject

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import kotlinx.coroutines.withContext
import java.time.LocalDate

class DiaDeLaSemana {

    private lateinit var diaHoy: String
    private var diaSemana = LocalDate.now().dayOfWeek.name

    fun diaSemana():String {

        if (!diaSemana.isNotEmpty()){
            // todo mensaje de alerta
            diaHoy = "Restringido"
        }else {

            when (diaSemana) {
                "Monday" -> {
                    diaHoy = "Lunes"
                }
                "Tuesday" -> {
                    diaHoy = "Martes"
                }
                "Wednesday" -> {
                    diaHoy = "Miercoles"
                }
                "thursday" -> {
                    diaHoy = "Jueves"
                }
                "Friday" -> {
                    diaHoy = "Viernes"
                }
                "Saturday" -> {
                    diaHoy = "Sabado"
                }
                "Sunday" -> {
                    diaHoy = "Domingo"
                }
                else -> {
                    diaHoy = "Domingo"
                }
            }
            return diaHoy
        }
        return diaHoy
    }
}