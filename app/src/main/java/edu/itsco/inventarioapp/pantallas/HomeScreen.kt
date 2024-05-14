package edu.itsco.inventarioapp.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.itsco.inventarioapp.navegacion.Pantallas
import edu.itsco.inventarioapp.ui.theme.InventarioAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Productos")
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    navController.navigate(
                        route = Pantallas.NuevoProducto.url
                    )
                }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                Text(text = "ADD")
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ){
        Column (modifier = Modifier.padding(it)){
            Text(text = "Pantalla principal")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    InventarioAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}