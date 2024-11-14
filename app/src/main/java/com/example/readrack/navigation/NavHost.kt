package com.example.readrack.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.readrack.ui.theme.screens.About
import com.example.readrack.ui.theme.screens.AllBooks
import com.example.readrack.ui.theme.screens.Detail
import com.example.readrack.ui.theme.screens.Home

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryFlow.collectAsState(initial = navController.currentBackStackEntry)
    val title = when (currentRoute.value?.destination?.route){
        "home" -> "Home"
        "allbooks" -> "All Books"
        "about" -> "About"
        "book_detail/{bookId}" -> "Detail"
        else -> ""}

    Scaffold(
        topBar = { TopBar(title = title) },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            Modifier.padding(innerPadding)
        ) {
            composable("home") { Home(navController) }
            composable("allbooks") { AllBooks(navController) }
            composable("about") { About() }
            composable(
                "book_detail/{bookId}",
                arguments = listOf(navArgument("bookId") { type = NavType.IntType })
            ) { backStackEntry ->
                val bookId = backStackEntry.arguments?.getInt("bookId") ?: 0
                Detail(bookId = bookId)
            }
        }
    }
}