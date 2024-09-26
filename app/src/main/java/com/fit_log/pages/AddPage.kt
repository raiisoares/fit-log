package com.fit_log.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddPage(onAddAnnotation: (String) -> Unit, modifier: Modifier = Modifier) {
    var annotation by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = annotation,
            onValueChange = { annotation = it },
            label = { Text("Anote algo...") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (annotation.isNotBlank()) {
                    onAddAnnotation(annotation)
                    annotation = "" // Limpa o campo
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Adicionar")
        }
    }
}
