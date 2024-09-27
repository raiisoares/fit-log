package com.fit_log.model

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import java.text.SimpleDateFormat
import java.util.*

class NotesViewModel : ViewModel() {

    private val _notesList = mutableStateOf<List<Notes>>(emptyList())
    val notesList: State<List<Notes>> = _notesList

    fun addNote(title: String, content: String, subject: String) {
        val currentDate = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(Date())
        val newNote =
            Notes(title = title, content = content, subject = subject, creationDate = currentDate)
        _notesList.value += newNote
    }

    fun deleteNote(noteToDelete: Notes) {
        _notesList.value = _notesList.value.filter { it != noteToDelete }
    }
}
