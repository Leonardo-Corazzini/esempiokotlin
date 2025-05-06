package com.seasistemi.esempiostruttura.ui.screen.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    navigateToLogin: () -> Unit,
    navigateToDettaglioPokemon: (String) -> Unit
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

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopAppBar(
            title = {
                Text(
                    "dashboard"
                )
            },
            actions = {
                IconButton(
                    onClick = {viewModel.logout()}
                ) {Icon(imageVector = Icons.Default.ExitToApp,null) }
            }
        )
        var searchValue by remember  { mutableStateOf("") }
        val listState = rememberLazyListState()
        val focusManager = LocalFocusManager.current
        LaunchedEffect(listState.isScrollInProgress) {
            if (listState.isScrollInProgress) {
                focusManager.clearFocus()
            }
        }
        OutlinedTextField(
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(0.3f).padding(5.dp),
            value = searchValue,
            onValueChange = { valoreAggiornato -> searchValue=valoreAggiornato}
        )

        LazyColumn(
            state = listState
        ) {
            items(uiState.pokemonList.filter { pokemon ->
                searchValue.isBlank() || pokemon.nome.contains(searchValue)
            }){ pokemon ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { navigateToDettaglioPokemon(pokemon.nome) },
                    border = BorderStroke(width = 2.dp, color = Color.LightGray)

                ) {
                    Row(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text= pokemon.nome
                        )

                    }
                }

            }

        }
    }
}