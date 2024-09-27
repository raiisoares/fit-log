@Composable
fun NoteDetailPage(note: Notes) {
    val noteTitleLabel = stringResource(id = R.string.note_title)
    val subjectLabel = stringResource(id = R.string.note_subject)
    val contentLabel = stringResource(id = R.string.note_content)
    val creationDateLabel = stringResource(id = R.string.note_creation_date)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = note.title, fontSize = 24.sp)
        Text(text = "$subjectLabel: ${note.subject}", fontSize = 20.sp)
        Text(text = "$contentLabel:", fontSize = 16.sp)
        Text(text = note.content, fontSize = 16.sp)
        Text(text = "$creationDateLabel: ${note.creationDate}", fontSize = 14.sp)
    }
}
