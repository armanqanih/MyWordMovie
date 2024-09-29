package org.lotka.xenonx.presentation.screens.detail.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenreChip(
    genre: String?=null
) {
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        border = BorderStroke(2.dp, Color.White),
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Text(
            text = genre?:"isNull",
            color = Color.White,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(8.dp),
            fontSize = 14.sp
        )
    }
}