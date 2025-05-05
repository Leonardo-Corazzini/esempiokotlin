package com.seasistemi.esempiostruttura.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    navigateToDashboard:()-> Unit
){
   val uiState by viewModel.state.collectAsState()
    LaunchedEffect(uiState.isLoggedIn) {
        if(uiState.isLoggedIn)  navigateToDashboard()
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


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Button(
            onClick = {viewModel.login()}
        ) {
            Text(
                text = "Login"
            )
        }

    }
}
