package com.example.ceibaparqueadero

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val motoDataBase = providesMotoDatabase(this)
        val motoDao = motoDataBase.motoDao()

        lifecycleScope.launchWhenCreated {
            //motoDao.insertVehiculoMoto(EntidadDatosMoto("ABC-123 ",true))
            findViewById<TextView>(R.id.texto).text =
                motoDao.getAllMotos().firstOrNull()?.numeroPlaca
        }
    }

    fun providesMotoDatabase(applicationContext: Context): MotoDataBase {
        return Room.databaseBuilder(
            applicationContext,
            MotoDataBase::class.java,
            "MotoDataBase"
        ).build()
    }
}