package com.example.doubleentitydb.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doubleentitydb.data.local.model.CarrosEntidad
import com.example.doubleentitydb.data.local.model.MarcaEntidad
import com.example.doubleentitydb.domain.PruebasRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: PruebasRepo
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        getCarros()
        getMarcas()
    }

    fun insertMarca(marca: MarcaEntidad) {

        viewModelScope.launch(Dispatchers.IO) {
            repo.insertMarca(marca)
        }

    }

    fun insertCarro(carro: CarrosEntidad) {

        viewModelScope.launch(Dispatchers.IO) {
            repo.insertCarro(carro)
        }

    }

    fun getCarros(){

        viewModelScope.launch {

            repo.getAllCarros().collectLatest {
                state = state.copy(
                    carrosList = it
                )
            }

        }

    }

    fun getMarcas(){

        viewModelScope.launch {

            repo.getAllMarcas().collectLatest {
                state = state.copy(
                    marcaList = it
                )
            }

        }

    }

}

data class HomeState(
    val carrosList : List<CarrosEntidad> = emptyList(),
    val marcaList : List<MarcaEntidad> = emptyList(),
)