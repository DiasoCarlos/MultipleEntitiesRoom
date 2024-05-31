package com.example.doubleentitydb.domain

import androidx.room.Query
import com.example.doubleentitydb.data.local.model.CarrosEntidad
import com.example.doubleentitydb.data.local.model.MarcaEntidad
import kotlinx.coroutines.flow.Flow

interface PruebasRepo {

    suspend fun insertMarca(marca : MarcaEntidad)

    suspend fun insertCarro(carro : CarrosEntidad)

    suspend fun getAllMarcas() : Flow<List<MarcaEntidad>>

    suspend fun getAllCarros() : Flow<List<CarrosEntidad>>

}