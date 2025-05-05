package com.seasistemi.esempiostruttura.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.ApiClient
import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.PokemonRemoteDataSource
import com.seasistemi.esempiostruttura.data.repository.PokemonRepository
import com.seasistemi.esempiostruttura.domain.AppUseCases
import com.seasistemi.esempiostruttura.domain.GetListaPokemon
import com.seasistemi.esempiostruttura.ui.navigation.Navigation
import com.seasistemi.esempiostruttura.ui.theme.EsempiostrutturaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            EsempiostrutturaTheme {
                Navigation()
            }
        }
    }
}
