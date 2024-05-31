package com.example.doubleentitydb.domain

import com.example.doubleentitydb.data.local.LocalDataSource
import com.example.doubleentitydb.data.local.model.CarrosEntidad
import com.example.doubleentitydb.data.local.model.MarcaEntidad
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PruebaRepoImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : PruebasRepo {

    override suspend fun insertMarca(marca: MarcaEntidad) {
        localDataSource.insertMarca(marca)
    }

    override suspend fun insertCarro(carro: CarrosEntidad) {
        localDataSource.insertarCarro(carro)
    }

    override suspend fun getAllMarcas(): Flow<List<MarcaEntidad>> {
        return localDataSource.getAllMarcas()
    }

    override suspend fun getAllCarros(): Flow<List<CarrosEntidad>> {
        return localDataSource.getAllCarros()
    }

}