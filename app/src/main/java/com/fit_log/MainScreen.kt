@Composable
fun MainScreen(modifier: Modifier = Modifier, notesViewModel: NotesViewModel = viewModel()) {
    val navItemList = listOf(
        NavItem("Add", ImageVector.vectorResource(R.drawable.ic_add_black_24dp)),
        NavItem("Dashboard", ImageVector.vectorResource(R.drawable.ic_dashboard_black_24dp)),
        NavItem("About", ImageVector.vectorResource(R.drawable.ic_info_black_24dp))
    )

    var selectedIndex by remember {
        mutableIntStateOf(1)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val navController = rememberNavController()

        Column(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "Dashboard",
                modifier = Modifier.weight(1f)
            ) {
                composable("Dashboard") {
                    DashboardPage(
                        annotations = notesViewModel.notesList.value,
                        navController = navController,
                        onDeleteNote = { noteToDelete ->
                            notesViewModel.deleteNote(noteToDelete)
                        }
                    )
                }

                composable("Add") {
                    AddPage(onAddNote = { title, content, subject ->
                        notesViewModel.addNote(title, content, subject)
                        navController.navigate("Dashboard")
                    })
                }

                composable("About") {
                    AboutPage()
                }

                composable("NoteDetail/{noteTitle}") { backStackEntry ->
                    val noteTitle = backStackEntry.arguments?.getString("noteTitle")
                    val note = notesViewModel.notesList.value.find { it.title == noteTitle }
                    if (note != null) {
                        NoteDetailPage(note = note)
                    }
                }
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
