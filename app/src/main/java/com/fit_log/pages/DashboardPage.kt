package com.fit_log.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardPage(annotations: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Dashboard")

        annotations.forEach { annotation ->
            Text(text = annotation, modifier = Modifier.padding(8.dp))
        }
    }
}