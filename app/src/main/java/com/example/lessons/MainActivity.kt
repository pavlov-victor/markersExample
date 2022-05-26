package com.example.lessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lessons.models.Marker
import com.example.lessons.ui.theme.LessonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val testMarkers = listOf<Marker>(
            Marker(1, "Viktor", "teacher", 1f, 2f),
            Marker(2, "Ivan", "student", 1f, 2f),
        )
        setContent {
            LessonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Scaffold(topBar = {
                        TopAppBar(elevation = 10.dp) {
                            Text("Lessons", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        }
                    }) {
                        for (marker in testMarkers) {

                        }
                    }
                }
            }
        }
    }
}
