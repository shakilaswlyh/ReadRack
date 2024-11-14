package com.example.readrack.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.readrack.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color(0xFFFEFAE0),
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFF798645)
        )
    )
}

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFF798645)
    ) {
        NavigationBarItem(
            selected = false,
            onClick = {navController.navigate("home")},
            label = { Text("Home", color = Color.White) },
            icon = {
                Icon(
                    Icons.Filled.Home,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "Home",
                    tint = Color.White
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {navController.navigate("allbooks")},
            label = { Text("All Books", color = Color.White) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.book),
                    contentDescription = "All Books",
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {navController.navigate("about")},
            label = { Text("About", color = Color.White) },
            icon = {
                Icon(
                    Icons.Filled.Person,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "About",
                    tint = Color.White
                )
            }
        )
    }
}


