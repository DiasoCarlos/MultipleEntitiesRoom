package com.example.doubleentitydb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.doubleentitydb.data.local.model.CarrosEntidad
import com.example.doubleentitydb.data.local.model.MarcaEntidad
import com.example.doubleentitydb.presentation.MainViewModel
import com.example.doubleentitydb.ui.theme.DoubleEntityDBTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoubleEntityDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel : MainViewModel = hiltViewModel()
) {

    val state = viewModel.state

    var carro by remember {
        mutableStateOf("")
    }
    var marca by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        LazyColumn {
            items(state.carrosList){
                Text(text = it.nombreCarro)
            }
        }

        TextField(
            value = carro,
            onValueChange = {
                carro = it
            },
            label = {
                Text(text = "Carro")
            }
        )
        Button(
            onClick = {
                viewModel.insertCarro(
                    CarrosEntidad(
                        nombreCarro = carro
                    )
                )
                carro = ""
            }
        ) {
            Text(text = "Add carro")
        }



        LazyColumn {
            items(state.marcaList){
                Text(text = it.nombreMarca)
            }
        }

        TextField(
            value = marca,
            onValueChange = {
                marca = it
            },
            label = {
                Text(text = "Marca")
            }
        )
        Button(
            onClick = {
                viewModel.insertMarca(
                    MarcaEntidad(
                        nombreMarca = marca
                    )
                )
                marca = ""
            }
        ) {
            Text(text = "Add Marca")
        }

    }

}
