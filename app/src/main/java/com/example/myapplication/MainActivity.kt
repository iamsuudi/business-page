package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Paragraphs()
            }
        }
    }
}

@Composable
fun GridBox(title: String, content: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier
            .background(color = color)
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = content,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp),
        )
    }
}

@Composable
fun Paragraphs(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(Modifier.weight(1f)) {
            GridBox(
                title = "Text composable",
                content = "Displays text and follows the recommended Material Design guidelines",
                color = Color(0xFFEADDFF),
                modifier = Modifier
                    .weight(1f)
            )
            GridBox(
                title = "Image composable",
                content = "Creates a composable that lays out and draws a given Painter class object",
                color = Color(0xFFD0BCFF),
                modifier = Modifier
                    .weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            GridBox(
                title = "Row composable",
                content = "A layout composable that places its children in a horizontal sequence",
                color = Color(0xFFB69DF8),
                modifier = Modifier
                    .weight(1f)
            )
            GridBox(
                title = "Column composable",
                content = "A layout composable that places its children in a vertical sequence",
                color = Color(0xFFF6EDFF),
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
fun BusinessCard() {
    val img = painterResource(R.drawable.android_logo)
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFFdbe6dc)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = img,
                contentDescription = "Android Logo",
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .width(150.dp)
                    .background(color = Color(0xFF182c35))
            )
            Text(text = "Jennifer Doe", fontSize = 32.sp, color = Color(0xFF182c35))
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 16.sp,
                color = Color(0xFF295e45),
                fontWeight = FontWeight.Bold
            )
        }
        Column(Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Row {
                Icon(Icons.Filled.Phone, contentDescription = "Phone", tint = Color(0xFF285E45))
                Text(
                    text = "+11 (123) 444 555 666",
                    color = Color(0xFF224F34),
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500)
                )
            }
            Row {
                Icon(
                    Icons.Filled.Share,
                    contentDescription = "@Social link icon",
                    tint = Color(0xFF285E45)
                )
                Text(
                    text = "@AndroidDev",
                    color = Color(0xFF223156),
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500)
                )
            }
            Row {
                Icon(Icons.Filled.Email, contentDescription = "Email", tint = Color(0xFF285E45))
                Text(
                    text = "william.@gmail.com",
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}