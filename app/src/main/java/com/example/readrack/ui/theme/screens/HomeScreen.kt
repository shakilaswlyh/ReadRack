package com.example.readrack.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavHostController
import com.example.readrack.data.BookData
import com.example.readrack.data.BookList

@Composable
fun Home(navController: NavHostController) {
    Scaffold(
        content = { paddingValues ->
            val popularBooks = BookList().subList(0, 9)
            val recentlyBooks = BookList().subList(10, 15)
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                Popular(books = popularBooks, navController = navController)
                Recently(books = recentlyBooks, navController = navController)
            }
        }
    )
}

@Composable
fun Popular(books: List<BookData>, navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Popular",
            color = Color(0xFF798645),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ))
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(books) { book ->
                PopularCard(book = book, navController = navController)
            }
        }
    }
}

@Composable
fun PopularCard(book: BookData, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("book_detail/${book.id}")
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F7)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = book.imageResId),
                contentDescription = book.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = book.title,
                color = Color.Black,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                ),
            )
            Text(
                text = book.author,
                style = TextStyle(
                    fontSize = 14.sp
                ),
            )
        }
    }
}

@Composable
fun Recently(books: List<BookData>, navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Recently",
            color = Color(0xFF798645),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ))
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(books) { book ->
                RecentlyCard(book = book, navController = navController)
            }
        }
    }
}

@Composable
fun RecentlyCard(book: BookData, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("book_detail/${book.id}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F7)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = book.title,
                    color = Color.Black,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                )
                Text(
                    text = book.author,
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
            }
            Image(
                painter = painterResource(id = book.imageResId),
                contentDescription = book.title,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

