package edu.itsco.inventarioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import edu.itsco.inventarioapp.navegacion.NavGraph
import edu.itsco.inventarioapp.pantallas.ProductoViewModel
import edu.itsco.inventarioapp.pantallas.ProductoViewModelFactory
import edu.itsco.inventarioapp.ui.theme.InventarioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val owner = LocalViewModelStoreOwner.current
            owner?.let {
                val navController = rememberNavController()
                val viewModel: ProductoViewModel = viewModel(
                    it,
                    "ProductoViewModel",
                    ProductoViewModelFactory(
                        application = this.application
                    )
                )
                InventarioAppTheme {
                    // A surface container using the 'background' color from the theme
                    NavGraph(navController = navController,
                        viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InventarioAppTheme {
        Greeting("Android")
    }
}