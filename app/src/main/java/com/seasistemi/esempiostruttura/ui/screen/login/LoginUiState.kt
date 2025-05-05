package com.seasistemi.esempiostruttura.ui.screen.login

data class LoginUiState(
    val isLoading : Boolean = false,
    val error : String? = null,
    val isLoggedIn: Boolean = false

)
