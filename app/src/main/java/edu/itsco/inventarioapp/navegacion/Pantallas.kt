package edu.itsco.inventarioapp.navegacion

sealed class Pantallas(val url: String) {
    object Home: Pantallas(url = "Home")
    object NuevoProducto: Pantallas(url = "nuevo_producto")
}