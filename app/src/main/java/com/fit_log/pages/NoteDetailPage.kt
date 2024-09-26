package com.fit_log.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit_log.model.Notes

@Composable
fun NoteDetailPage(note: Notes) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = note.title, fontSize = 24.sp)
        Text(text = "Assunto: ${note.subject}", fontSize = 20.sp)
        Text(text = "Conteúdo:", fontSize = 16.sp)
        Text(text = note.content, fontSize = 16.sp)
        Text(text = "Criado em: ${note.creationDate}", fontSize = 14.sp)
    }
}