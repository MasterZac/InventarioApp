package edu.itsco.inventarioapp.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.itsco.inventarioapp.navegacion.Pantallas
import edu.itsco.inventarioapp.ui.theme.InventarioAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevoProductoScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Nuevo Producto")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(
                            route = Pantallas.Home.url
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ){
        Formulario(Modifier.padding(it))
    }
}

@Composable
fun Formulario(modifier: Modifier = Modifier){
    var nombre by remember { mutableStateOf("")}
    var precio by remember { mutableDoubleStateOf(0.0)}
    var cantidad by remember { mutableIntStateOf(0) }

    Column (
        modifier = Modifier
            .padding(top = 64.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
    ){
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = "Nombre")},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = precio.toString(),
            onValueChange = { precio = it.toDouble()},
            label = { Text(text = "Precio")},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = cantidad.toString(),
            onValueChange = { cantidad = it.toInt()},
            label = { Text(text = "Cantidad")},
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewNuevoProducto(){
    InventarioAppTheme {
        NuevoProductoScreen(navController = rememberNavController())
    }
}