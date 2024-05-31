package com.example.doubleentitydb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.doubleentitydb.data.local.model.CarrosEntidad
import com.example.doubleentitydb.data.local.model.MarcaEntidad
import com.example.doubleentitydb.domain.PruebasDao

@Database(entities = [MarcaEntidad::class, CarrosEntidad::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pruebaDao() : PruebasDao

}