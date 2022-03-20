package com.example.domain.factory

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