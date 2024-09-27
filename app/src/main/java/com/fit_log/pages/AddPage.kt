@Composable
fun NoteDetailPage(note: Notes) {
    val titleText = stringResource(id = R.string.note_details)
    val titleLabel = stringResource(id = R.string.note_title)
    val subjectLabel = stringResource(id = R.string.note_subject)
    val contentLabel = stringResource(id = R.string.note_content)
    val creationDateLabel = stringResource(id = R.string.note_creation_date)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = titleText,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = note.title,
            onValueChange = {},
            label = { Text(titleLabel) },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = note.subject,
            onValueChange = {},
            label = { Text(subjectLabel) },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = note.content,
            onValueChange = {},
            label = { Text(contentLabel) },
            readOnly = true,
            maxLines = 5,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = note.creationDate,
            onValueChange = {},
            label = { Text(creationDateLabel) },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}
