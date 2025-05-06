package com.seasistemi.esempiostruttura.ui.screen.dettagliopokemon

import com.seasistemi.esempiostruttura.data.model.DettaglioPokemon
import com.seasistemi.esempiostruttura.data.model.Pokemon

data class DettaglioPokemonUiState(
    val isLoading : Boolean = false,
    val error : String? = null,
    val pokemon: DettaglioPokemon? = null
)
