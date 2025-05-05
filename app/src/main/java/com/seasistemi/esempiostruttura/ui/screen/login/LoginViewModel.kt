package com.seasistemi.esempiostruttura.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seasistemi.esempiostruttura.domain.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: AppUseCases
) : ViewModel() {
    private val _state = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = _state.asStateFlow()
    fun login(){
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(isLoading = true)
            }
            try {
                delay(1000)
                _state.update { currentState ->
                    currentState.copy(isLoggedIn = true)
                }
            } catch (e: Exception) {
                _state.update { currentState ->
                    currentState.copy(error = "Errore generico")
                }
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
}