package com.seasistemi.esempiostruttura.ui.screen.dettagliopokemon

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.seasistemi.esempiostruttura.domain.AppUseCases
import com.seasistemi.esempiostruttura.ui.navigation.DettaglioPokemonScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DettaglioPokemonViewModel @Inject constructor(
    private val useCases: AppUseCases,
     savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(DettaglioPokemonUiState())
    val state: StateFlow<DettaglioPokemonUiState> = _state.asStateFlow()
    private val pokemonId = savedStateHandle.toRoute<DettaglioPokemonScreen>()
    init {
        getPokemon(pokemonId.nome)

    }

    fun clearError(){
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(error = null)
            }
        }
    }
    fun getPokemon(nome : String){
        viewModelScope.launch {
            try {
                _state.update { currentState ->
                    currentState.copy(isLoading = true)
                }
                val dettaglio = useCases.getPokemon(nome)
                _state.update { currentState ->
                    currentState.copy(
                        pokemon = dettaglio,
                        isLoading = false)
                }
            } catch (e: Exception){
                _state.update { currentState ->
                    currentState.copy(error = e.message?: "Errore generico", isLoading = false)
                }
            }


        }
    }


}