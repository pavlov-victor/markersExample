package com.example.lessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lessons.components.MarkerCard
import com.example.lessons.database.MarkerService
import com.example.lessons.models.Marker
import com.example.lessons.ui.theme.LessonsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val markers = mutableStateOf(listOf<Marker>())

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
                        Column() {
                            Button(onClick = {
                                CoroutineScope(Dispatchers.IO).launch {
                                    val retrofit = Retrofit
                                        .Builder()
                                        .baseUrl("https://itcube.goykt.ru/")
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()
                                    val result = retrofit.create(MarkerService::class.java).getMarkers().execute()
                                    val newMakers: List<Marker> = result.body() as List<Marker>
                                    markers.value = newMakers
                                }
                            }) {
                                Text(text = "Получить маркеры")
                            }
                            for (marker in markers.value) {
                                MarkerCard(marker = marker)
                            }
                        }
                    }
                }
            }
        }
    }
}
