package com.example.insfrastructure.accesodatos.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MotoDto(@PrimaryKey var numeroPlaca: String, var cilindrajeAlto: Boolean) {
}