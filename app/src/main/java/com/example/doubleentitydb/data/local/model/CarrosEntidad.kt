package com.example.doubleentitydb.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "carros_table")
data class CarrosEntidad(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nombreCarro : String
)
