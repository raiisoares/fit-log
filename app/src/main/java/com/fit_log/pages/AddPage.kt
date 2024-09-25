package com.fit_log.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddPage(onAddAnnotation: (String) -> Unit, modifier: Modifier = Modifier) {
    var annotation by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1976D2)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo de texto para entrada de anotação
        TextField(
            value = annotation,
            onValueChange = { annotation = it },
            label = { Text("Anote algo...") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Botão para adicionar a anotação
        Button(onClick = {
            if (annotation.isNotBlank()) {
                onAddAnnotation(annotation) // Chama a função de callback
                annotation = "" // Limpa o campo após adicionar
            }
        }) {
            Text("Adicionar", color = Color.White)
        }
    }
}
