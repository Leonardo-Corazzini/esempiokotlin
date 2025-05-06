package com.seasistemi.esempiostruttura.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.seasistemi.esempiostruttura.data.repository.PokemonRepository
import com.seasistemi.esempiostruttura.domain.AppUseCases
import com.seasistemi.esempiostruttura.ui.screen.login.LoginScreen
import com.seasistemi.esempiostruttura.ui.screen.login.LoginViewModel
import kotlinx.serialization.Serializable
import com.seasistemi.esempiostruttura.ui.screen.dashboard.DashboardViewModel
import com.seasistemi.esempiostruttura.ui.screen.dashboard.DashboardScreen
import com.seasistemi.esempiostruttura.ui.screen.dettagliopokemon.DettaglioPokemonScreen
import com.seasistemi.esempiostruttura.ui.screen.dettagliopokemon.DettaglioPokemonViewModel
import kotlinx.coroutines.launch

@Serializable
object LoginScreen

@Serializable
object DashboardScreen

@Serializable
data class DettaglioPokemonScreen(val nome : String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(){
    val navController = rememberNavController()
    val snackbarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = { Snackbar { Text(it.visuals.message) } }
            )
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                coroutineScope.launch {
//                    snackbarHostState.showSnackbar("click su fab", duration = SnackbarDuration.Short)
//                }
//            }) {
//                Icon(Icons.Default.Add,null)
//            }
//        }
    ) {  padding ->
        NavHost(
            modifier = Modifier.padding(padding),
            navController = navController,
            startDestination = LoginScreen,
        ) {

            composable<LoginScreen> {
                val viewModel: LoginViewModel = hiltViewModel()

                LoginScreen(
                    viewModel = viewModel,
                    navigateToDashboard = {
                        navController.navigate(DashboardScreen) {
                            popUpTo(DashboardScreen) { inclusive = true }
                        }
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(message = "Mi sposto",  duration = SnackbarDuration.Short)
                        }
                    }
                )
            }
            composable<DashboardScreen> {
                val viewModel: DashboardViewModel = hiltViewModel()
                DashboardScreen(
                    viewModel = viewModel,
                    navigateToLogin = {
                        navController.navigate(LoginScreen) {
                            popUpTo(LoginScreen) { inclusive = true }
                        }
                    },
                    navigateToDettaglioPokemon ={ nome ->
                        navController.navigate(route = DettaglioPokemonScreen(nome = nome))
                    }
                )
            }
            composable<DettaglioPokemonScreen> { backStackEntry ->
                val viewModel: DettaglioPokemonViewModel = hiltViewModel()
//                val pokemon = backStackEntry.toRoute<DettaglioPokemonScreen>()
                DettaglioPokemonScreen(
                    viewModel = viewModel,
                )
            }


        }


    }


}