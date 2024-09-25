package com.fit_log

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.fit_log.model.NavItem
import com.fit_log.pages.AboutPage
import com.fit_log.pages.AddPage
import com.fit_log.pages.DashboardPage

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navItemList = listOf(
        NavItem("Add", ImageVector.vectorResource(R.drawable.ic_add_black_24dp)),
        NavItem("Dashboard", ImageVector.vectorResource(R.drawable.ic_dashboard_black_24dp)),
        NavItem("About", ImageVector.vectorResource(R.drawable.ic_info_black_24dp))
    )

    var selectedIndex by remember {
        mutableIntStateOf(1)
    }

    // Contexto da atividade atual
    val context = LocalContext.current

    // Estado para armazenar as anotações
    var annotationsList by remember { mutableStateOf(listOf<String>()) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val navController = rememberNavController()
        Column(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "Dashboard",
                modifier = Modifier.weight(1f)
            ) {
                composable("Dashboard") {
                    DashboardPage(annotations = annotationsList) // Passa a lista de anotações
                }

                composable("Add") {
                    AddPage(onAddAnnotation = { annotation ->
                        annotationsList = annotationsList + annotation // Adiciona a anotação à lista
                        navController.navigate("Dashboard") // Navega para o Dashboard após adicionar
                    })
                }

                composable("About") {
                    AboutPage()
                }
            }

            // Botão para abrir a tela MariaEduardaInfoActivity
            Button(
                onClick = {
                    // Inicia a MariaEduardaInfoActivity
                    val intent = Intent(context, MariaEduardaInfoActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Abrir Informações Maria Eduarda")
            }

            BottomAppBar(actions = {
                NavigationBar {
                    navItemList.forEachIndexed { index, navItem ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = {
                                selectedIndex = index
                                val route = when (index) {
                                    0 -> "Add"
                                    1 -> "Dashboard"
                                    else -> "About"
                                }
                                navController.navigate(route, navOptions = navOptions {
                                    launchSingleTop = true
                                    popUpTo(navController.graph.id)
                                })
                            },
                            icon = {
                                Icon(imageVector = navItem.icon, contentDescription = "Icon")
                            },
                            label = {
                                Text(navItem.label)
                            }
                        )
                    }
                }
            })
        }
    }
}
