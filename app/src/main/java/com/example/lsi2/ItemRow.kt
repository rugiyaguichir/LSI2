package com.example.lsi2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lsi2.ui.theme.Purple40

@Composable
fun MyRow(item: ItemRowModel) {


    Column(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
    ) {
            Box(
                modifier = Modifier
                    .padding(3.dp)
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(
                        shape = CircleShape,
                        width = 1.dp,
                        color = Color.White)

            ) {
                Image(
                    painter = painterResource(id = item.imageId),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = item.title)

        }
    }