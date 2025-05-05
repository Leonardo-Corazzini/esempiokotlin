package com.seasistemi.esempiostruttura.ui.screen.dashboard

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seasistemi.esempiostruttura.data.repository.PokemonRepository
import com.seasistemi.esempiostruttura.domain.AppUseCases
import com.seasistemi.esempiostruttura.ui.screen.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val useCases: AppUseCases
) : ViewModel() {
    private val _state = MutableStateFlow(DashboardUiState())
    val state: StateFlow<DashboardUiState> = _state.asStateFlow()
    init {
        fetchPokemonList()
    }
    fun logout(){
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(isLoading = true)
            }

            _state.update { currentState ->
                currentState.copy(isLoggedIn = false)
            }

        }

    }
    fun clearError(){
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(error = "")
            }
        }
    }

    fun fetchPokemonList(){

        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(isLoading = true)
            }
            try {
                val res = useCases.getListaPokemon()
                _state.update { currentState ->
                    currentState.copy(pokemonList = res, isLoading = false)
                }
            } catch (e: Exception){
                _state.update { currentState ->
                    currentState.copy(error = e.message?: "Errore generico ", isLoading = false)
                }
            }

        }
    }

}