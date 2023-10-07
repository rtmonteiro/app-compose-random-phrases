package com.rtmonteiro.randomphrases

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rtmonteiro.randomphrases.ui.theme.RandomPhrasesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomPhrasesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        IconButton(R.drawable.baseline_pets_24, Modifier.weight(1f))
                        IconButton(R.drawable.baseline_pets_24, Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun IconButton(resource: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .clickable { println("Button Clicked!") }
            .padding(16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally),
        color = MaterialTheme.colorScheme.surface
    ) {
        Image(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = resource), contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun LauncherPreview() {
    val inputValue = remember { mutableStateOf(TextFieldValue()) }

    RandomPhrasesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(64.dp)
                    .fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,

            ) {
                Text(text = "Frases de gatos e cachorros")
                TextField(
                    value = inputValue.value,
                    onValueChange = { inputValue.value = it },
                    label = { Text("Digite seu nome") },
                )
                Button(onClick = { println("Button Clicked!") }) {
                    Text(text = "Guardar")
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomePreview() {
    val name = "Ryan"
    RandomPhrasesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .background(MaterialTheme.colorScheme.inversePrimary)
                ) {
                    IconButton(R.drawable.baseline_pets_24, Modifier.weight(1f))
                    IconButton(R.drawable.baseline_pets_24, Modifier.weight(1f))
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(64.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Olá, $name")
                    Text(text = "miau miau")
                    Button(onClick = { println("Button Clicked!") }) {
                        Text(text = "Gerar outra frase")
                    }
                }
            }
        }
    }
}