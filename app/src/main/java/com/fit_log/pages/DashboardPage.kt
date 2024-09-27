package com.fit_log.pages
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fit_log.R
import com.fit_log.model.Notes

@Composable
fun DashboardPage(
    annotations: List<Notes>,
    navController: NavController,
    onDeleteNote: (Notes) -> Unit
) {
    val dashboardTitle = stringResource(id = R.string.dashboard_title)

    Column {
        Text(
            text = dashboardTitle,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(annotations) { note ->
                NoteCard(note, navController, onDeleteNote)
            }
        }
    }
}

@Composable
fun NoteCard(note: Notes, navController: NavController, onDeleteNote: (Notes) -> Unit) {
    val deleteNoteText = stringResource(id = R.string.delete_note)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate("NoteDetail/${note.title}")
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = note.subject,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = deleteNoteText,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.clickable { onDeleteNote(note) }
            )
        }
    }
}
