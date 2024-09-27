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
