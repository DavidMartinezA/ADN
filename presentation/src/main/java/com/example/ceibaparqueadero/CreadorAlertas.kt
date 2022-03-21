package com.example.ceibaparqueadero

import android.app.AlertDialog
import android.content.Context

class CreadorAlertas() {

    fun mostrarDialogoAlerta(context: Context,titulo: String, mensaje: String) {
        AlertDialog.Builder(context)
            .setTitle(titulo)
            .setMessage(mensaje)
            .show()
    }
}