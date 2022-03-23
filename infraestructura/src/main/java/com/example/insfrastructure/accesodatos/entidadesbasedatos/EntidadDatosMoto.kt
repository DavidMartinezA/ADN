package com.example.insfrastructure.accesodatos.entidadesbasedatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EntidadDatosMoto(@PrimaryKey var numeroPlaca: String, var cilindrajeAlto: Boolean) {
}