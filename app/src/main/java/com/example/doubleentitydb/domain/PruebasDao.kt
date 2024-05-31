package com.example.doubleentitydb.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.doubleentitydb.data.local.model.CarrosEntidad
import com.example.doubleentitydb.data.local.model.MarcaEntidad
import kotlinx.coroutines.flow.Flow

@Dao
interface PruebasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarca(marca : MarcaEntidad)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarro(carro : CarrosEntidad)

    @Query("select * from marca_table")
    fun getAllMarcas() : Flow<List<MarcaEntidad>>

    @Query("select * from carros_table")
    fun getAllCarros() : Flow<List<CarrosEntidad>>

}