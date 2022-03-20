package com.example.ceibaparqueadero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  val carroJuan= Carro("hsu547")
        val motoJuan= Moto("lid50c", false)
        val parqueaderoCeiba = Parqueadero(this)

        var dia : FechaCalendario = FechaCalendario()


        parqueaderoCeiba.ingresoVehiculos(carroJuan, dia.diaSemana())
        parqueaderoCeiba.ingresoVehiculos(motoJuan, dia.diaSemana())
        val tarifaCarro =  parqueaderoCeiba.cobroTarifaCarro(9.0, carroJuan).toString()
        val tarifaMoto =  parqueaderoCeiba.cobroTarifaMoto(5.0, motoJuan).toString()

        Log.i("Prueba de Codigo 1",tarifaCarro)
        Log.i("Prueba de Codigo 2",tarifaMoto)*/
    }
}