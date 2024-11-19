package com.example.ejercicio01examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio01examen.ui.theme.Ejercicio01ExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio01ExamenTheme {
                Scaffold { paddingValues ->
                    val videojuegos = listOf(
                        Videojuego("Super Mario Bros", 50, "https://loremflickr.com/400/400/games?lock=1"),
                        Videojuego("Zelda: Breath of the Wild", 60, "https://loremflickr.com/400/400/games?lock=2"),
                        Videojuego("God of War", 70, "https://loremflickr.com/400/400/games?lock=3"),
                        Videojuego("Cyberpunk 2077", 45, "https://loremflickr.com/400/400/games?lock=4")
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        VideojuegosList(videojuegos)
                    }
                }
            }
        }
    }
}

// 1Data class
data class Videojuego(
    val name: String,
    val price: Int,
    val imageURL: String
)

// 2LazyColumn
@Composable
fun VideojuegosList(videojuegos: List<Videojuego>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(videojuegos) { videojuego ->
            VideojuegoCard(videojuego)
        }
    }
}

// 3. VideojuegoCard
@Composable
fun VideojuegoCard(videojuego: Videojuego) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Imagen
        AsyncImage(
            model = videojuego.imageURL,
            contentDescription = videojuego.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Nombre del videojuego
        Text(
            text = videojuego.name,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(4.dp))

        // Precio del videojuego
        Text(
            text = "$${videojuego.price}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}