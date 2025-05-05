package com.seasistemi.esempiostruttura.ui.screen.dashboard

import com.seasistemi.esempiostruttura.data.model.Pokemon

data class DashboardUiState(
    val isLoading : Boolean = false,
    val error : String? = null,
    val isLoggedIn : Boolean = true,
    val pokemonList: List<Pokemon> = emptyList()
)
