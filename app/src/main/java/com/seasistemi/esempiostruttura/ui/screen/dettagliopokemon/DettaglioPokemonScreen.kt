package com.seasistemi.esempiostruttura.ui.screen.dettagliopokemon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.seasistemi.esempiostruttura.ui.navigation.DettaglioPokemonScreen
import com.seasistemi.esempiostruttura.ui.screen.dashboard.DashboardViewModel

@Composable
fun DettaglioPokemonScreen(
    viewModel: DettaglioPokemonViewModel
){
    val uiState by viewModel.state.collectAsState()
    if(uiState.isLoading){
        AlertDialog(
            text = { CircularProgressIndicator() },
            onDismissRequest = {},
            confirmButton = {}
        )

    }
    val errore = uiState.error
    if(errore != null){
        AlertDialog(
            text = {
                Text(
                    text = errore
                )
            },
            onDismissRequest = {},
            confirmButton = {
                TextButton(
                    onClick = {viewModel.clearError()}
                ) {
                    Text(
                        text = "OK"
                    )
                }
            }
        )


    }
    Row  (
        modifier = Modifier.fillMaxSize()
    ){
        Card (
            colors = CardDefaults.cardColors(containerColor = Color.Cyan),
            modifier = Modifier.weight(1f).padding(10.dp),
            border = BorderStroke(width = 3.dp, color = Color.Yellow),


        ){
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth,
                model = uiState.pokemon?.urlImg,
                contentDescription = null,
            )
        }
        Column (
            modifier = Modifier.weight(1f)
        ){
            Card (
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                shape = MaterialTheme.shapes.large
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    AsyncImage(
                        model = uiState.pokemon?.urlImg,
                        contentDescription = null,
                    )
                    Text(
                        text = "No. ${uiState.pokemon?.numeroPokedex}  ${uiState.pokemon?.nome}",

                    )
                }

            }
            Column {
                Card (
                    modifier = Modifier.fillMaxWidth().padding(10.dp).weight(1f)
                ){
                    Row {  }
                    Column(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Row {
                            Text(
                                text = "Type  ${uiState.pokemon?.tipo}"
                            )
                        }
                        Row {
                            Text(
                                text = "Height  ${uiState.pokemon?.altezza}"
                            )
                        }
                        Row {Text(
                                text = "Weight  ${uiState.pokemon?.peso} lbs"
                        )  }
                    }
                }
                Card (
                    modifier = Modifier.fillMaxWidth().padding(10.dp).weight(1f)
                ){
                    Column(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = "E un bel pokemon"
                        )
                    }


                }
            }

        }

    }
}