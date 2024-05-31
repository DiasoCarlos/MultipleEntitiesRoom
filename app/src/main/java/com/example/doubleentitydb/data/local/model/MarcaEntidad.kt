package com.example.doubleentitydb.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "marca_table")
data class MarcaEntidad(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nombreMarca : String
)
