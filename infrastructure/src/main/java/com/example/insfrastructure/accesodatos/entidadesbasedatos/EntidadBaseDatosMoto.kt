package com.example.insfrastructure.accesodatos.entidadesbasedatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EntidadBaseDatosMoto(@PrimaryKey var numeroPlaca: String, var cilindrajeAlto: Boolean) {
}