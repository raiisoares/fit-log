package com.fit_log

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NotesViewModel : ViewModel() {
    private val _annotationsList = mutableStateListOf<String>()
    val annotationsList: List<String> get() = _annotationsList

    fun addAnnotation(annotation: String) {
        _annotationsList.add(annotation)
    }
}
