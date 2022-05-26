package com.example.lessons.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lessons.models.Marker


@Composable
fun MarkerCard(marker: Marker) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 10.dp)
            .height(100.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = marker.name)
        }
    }
}