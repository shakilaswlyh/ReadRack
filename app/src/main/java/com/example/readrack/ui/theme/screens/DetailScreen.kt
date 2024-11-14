package com.example.readrack.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readrack.data.BookData
import com.example.readrack.data.BookList
@Composable
fun Detail(bookId: Int) {
    val book = BookList().find { it.id == bookId }

    book?.let {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    Image(
                        painter = painterResource(id = it.imageResId),
                        contentDescription = it.title,
                        modifier = Modifier
                            .width(150.dp)
                            .height(200.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = it.title,
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.Black
                    )
                    Text(
                        text = "by ${it.author}",
                        style = TextStyle(
                            fontSize = 18.sp
                        ),
                        color = Color.Gray
                    )
                }
                    Spacer(modifier = Modifier.height(16.dp))
                    Synopsis(book = it)
                }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFF626F47)
                        ),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Read Now",
                            color = Color(0xFFFEFAE0),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        )
                    }
    }
}

@Composable
fun Synopsis(book: BookData) {
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F7))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${book.synopsis}",
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}
