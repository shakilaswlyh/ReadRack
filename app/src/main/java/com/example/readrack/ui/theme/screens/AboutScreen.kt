package com.example.readrack.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readrack.R

@Composable
fun About() {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(8.dp)) {
                Profile()
                ReadRack()
            }
        }
    )
}

@Composable
fun Profile() {
        Card(
            shape = CircleShape,
            modifier = Modifier.size(150.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.kila),
                contentDescription = "Profile Picture",
                modifier = Modifier.fillMaxWidth()
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            TableRow(label = "Nama", value = ": Shakila Aswaliyah")
            TableRow(label = "Email", value = ": shakilaaswaliyah@gmail.com")
            TableRow(label = "Asal Perguruan Tinggi", value = ": Politeknik Negeri Batam")
            TableRow(label = "Jurusan", value = ": Teknik Informatika")
            TableRow(label = "Program Studi", value = ": Teknologi Rekayasa Perangkat Lunak")
        }
    }

@Composable
fun TableRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.weight(0.5f),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = value,
            modifier = Modifier.weight(1f),
            style = TextStyle(
                fontSize = 14.sp,
            )
        )
    }
}

@Composable
fun ReadRack() {
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
                text = "ReadRack",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Aplikasi ReadRack adalah platform yang dirancang untuk memudahkan pengguna dalam " +
                        "mengeksplorasi dan mengelola buku-buku yang disediakan oleh aplikasi. Fitur utamanya " +
                        "mencakup daftar buku populer, buku yang baru dibaca, dan semua buku yang tersedia di " +
                        "aplikasi. Pengguna dapat dengan mudah menemukan berbagai pilihan buku untuk dibaca, " +
                        "melihat buku yang sudah dibaca, dan melihat rekomendasi buku-buku populer yang dapat " +
                        "menambah wawasan mereka. Dengan tampilan yang user-friendly, ReadRack menawarkan " +
                        "pengalaman yang menyenangkan dan praktis bagi para pembaca dalam menemukan buku-buku " +
                        "berkualitas yang dapat memperkaya pengetahuan mereka.",
                style = TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAboutScreen() {
    About()
}
