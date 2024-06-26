package edu.itsco.inventarioapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.itsco.inventarioapp.pantallas.HomeScreen
import edu.itsco.inventarioapp.pantallas.NuevoProductoScreen
import edu.itsco.inventarioapp.pantallas.ProductoViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: ProductoViewModel
){
    NavHost(
        navController = navController,
        startDestination = Pantallas.Home.url
    ) {
        composable(route = Pantallas.Home.url){
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Pantallas.NuevoProducto.url){
            NuevoProductoScreen(navController = navController, viewModel = viewModel)
        }
    }
}