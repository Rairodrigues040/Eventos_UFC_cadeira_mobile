package com.rai.aulamobileeventosufc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.aulamobileeventosufc.ui.theme.AulaMobileEventosUFCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaMobileEventosUFCTheme {
                Evento()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evento() {

    var nomeParticipante by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EVENTOS UFC") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->

        Card(modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(),
            shape = RectangleShape) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Workshop: Meu Primeiro App Android",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = "Aprenda os primeiros passos com Kotlin e Jetpack Compose",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = "22 de outubro - 16:00",
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Text(
                    text = "Campus de Russas - Laboratório 01"
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text("Inscrições")

                Text("Digite seu nome para demonstrar interesse:")

                TextField(
                    value = nomeParticipante,
                    onValueChange = {
                        nomeParticipante = it
                    },
                    placeholder = {
                        Text("Nome do participante")
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Button(
                    onClick = {},
                    enabled = nomeParticipante.isNotBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("QUERO PARTICIPAR")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Evento()
}