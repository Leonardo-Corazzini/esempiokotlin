package com.seasistemi.esempiostruttura.ui.screen.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    navigateToLogin: () -> Unit
){
    val uiState by viewModel.state.collectAsState()
    LaunchedEffect(!uiState.isLoggedIn) {
        if(!uiState.isLoggedIn)  navigateToLogin()
    }
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
                        text = "ok"
                    )
                }
            }
        )


    }

    Column {
        TopAppBar(
            title = {
                Text(
                    "dashboard"
                )
            },
            actions = {
                IconButton(
                    onClick = {viewModel.logout()}
                ) {Icon(imageVector = Icons.Default.AccountCircle,null) }
            }
        )
        LazyColumn {
            items(uiState.pokemonList){ pokemon ->
                Card {
                    Text(
                        text= pokemon.nome
                    )
                }

            }

        }
    }
}