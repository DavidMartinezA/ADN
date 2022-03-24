package com.example.dominio.vehiculo.servicio


import java.time.LocalDate

class FechaCalendario {

    private lateinit var diaHoy: String
    var diaSemana = LocalDate.now().dayOfWeek.name
    val formato = "yyyy/MM/dd HH:mm:ss"
    private var fechaDeHoy = LocalDate.parse(formato).toString()

    fun obtenerFechaHoy(): String {
        return fechaDeHoy
    }

    fun obtenerDiaSemana(): String {

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
                diaHoy = ""
            }
        }
        return diaHoy
    }

}
