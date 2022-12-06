/*
 * Copyright (c) 2022. StulSoft
 */

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication

@Composable
@Preview
fun app() {
    val numberPattern = remember { Regex("^-?\\d+$") }
    val counter = remember { mutableStateOf(0) }
    var text by remember { mutableStateOf("Hello, World!") }
    var myText by remember { mutableStateOf("My hello 1") }
    var numberField by remember { mutableStateOf("123") }
    var textField by remember { mutableStateOf("text") }

    MaterialTheme {
        Row {
            Column(modifier = Modifier.padding(20.dp)) {
                Button(onClick = {
                    text = "Hello, Desktop!"
                }) {
                    Text(text)
                }

                Button(onClick = {
                    myText = "My hello 2"
                }) {
                    Text(myText)
                }

                Button(onClick = {
                    counter.value++
                }) {
                    Text("counter ${counter.value}")
                }

                Button(onClick = {
                    counter.value = 0
                }) {
                    Text("Reset")
                }
            }

            Column(modifier = Modifier.padding(20.dp)) {
                TextField(
                    value = numberField,
                    onValueChange = {
                        if (it.isEmpty() || it.matches(numberPattern)) {
                            numberField = it
                        }
                        /*textField = it*/
                    },
                    label = { Text("The integer value:") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                
                TextField(
                    value = textField,
                    onValueChange = { textField = it },
                    label = { Text("The text value:") }
                )
            }
        }
    }
}

fun main() = singleWindowApplication(
    state = WindowState(size = DpSize(500.dp, 300.dp)),
    title = "Simple App 1"
) { app() }
