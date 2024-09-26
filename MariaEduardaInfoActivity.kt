package com.fit_log

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource // Importar para acessar strings
import androidx.compose.ui.unit.dp
import com.fit_log.ui.theme.FitlogTheme

class MariaEduardaInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitlogTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserInfo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UserInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFAE3E3)), // Rosa claro como fundo
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = stringResource(id = R.string.title_activity_maria_eduarda_info), // Usando a string do XML
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFFBB4F9A),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Exibir a imagem em um Box para manter as bordas arredondadas
        Box(
            modifier = Modifier
                .size(120.dp) // Tamanho da imagem
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp)) // Fundo branco e bordas arredondadas
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background), // Nome da imagem
                contentDescription = "Imagem de Maria Eduarda",
                modifier = Modifier.fillMaxSize(), // Preenche o Box
                contentScale = ContentScale.Crop // Para cortar a imagem se necessário
            )
        }

        // Informações do usuário
        InfoCard(label = stringResource(id = R.string.info_name), value = stringResource(id = R.string.user_name))
        InfoCard(label = stringResource(id = R.string.info_age), value = stringResource(id = R.string.user_age))
        InfoCard(label = stringResource(id = R.string.info_course), value = stringResource(id = R.string.user_course))
        InfoCard(label = stringResource(id = R.string.info_university), value = stringResource(id = R.string.user_university))
    }
}

@Composable
fun InfoCard(label: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(60.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)) // Fundo branco
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = label, style = MaterialTheme.typography.bodyLarge, color = Color(0xFF6C4F93))
            Text(text = value, style = MaterialTheme.typography.bodyLarge, color = Color(0xFF6C4F93))
        }
    }
}
