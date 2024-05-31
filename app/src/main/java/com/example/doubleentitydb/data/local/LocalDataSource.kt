package com.example.doubleentitydb.data.local

import androidx.room.Query
import com.example.doubleentitydb.data.local.model.CarrosEntidad
import com.example.doubleentitydb.data.local.model.MarcaEntidad
import com.example.doubleentitydb.domain.PruebasDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val pruebasDao: PruebasDao
)  {

    suspend fun insertMarca(marca : MarcaEntidad){
        pruebasDao.insertMarca(marca)
    }

    suspend fun insertarCarro(carro: CarrosEntidad){
        pruebasDao.insertCarro(carro)
    }

    suspend fun getAllMarcas() : Flow<List<MarcaEntidad>> {
        return pruebasDao.getAllMarcas()
    }

    suspend fun getAllCarros() : Flow<List<CarrosEntidad>> {
        return pruebasDao.getAllCarros()
    }

}