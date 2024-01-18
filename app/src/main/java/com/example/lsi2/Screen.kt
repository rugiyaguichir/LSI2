package com.example.lsi2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Screen1(navController: NavController){


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var text by remember { mutableStateOf("") }

        Column {
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("Enter text") },
                modifier = Modifier.padding(16.dp)
            )

        }

        Button(onClick = { navController.navigate("screen2") }) {
            Text("ПОИСК")
        }
    }



}

@Composable
fun Screen2(navController: NavController) {
    Column(){
        Image(painter = painterResource(id = R.drawable.photo_1),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(3.dp)
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp)
        ) {
            Text(text = "Name and Surname")
            Text(text = "This is a short Description and some Information about this person.")
        }

        Column(){
            Button(onClick = { navController.navigate("screen3") }) {
                Text("ВЫБРАТЬ ВРАЧА")
            }
        }
    }


}

@Composable
fun Screen3() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.photo_1),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .size(50.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Our services",
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(15.dp)
//                    elevation = 0.dp
                ) {
                    Box(modifier = Modifier.padding(5.dp)) {
                        LazyColumn(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray),
                        ) {
                            itemsIndexed(
                                listOf(
                                    ItemRowModel(R.drawable.photo_1, "Dentist", "dhsgfdkjghehrgwekwfjwlfwnefklsdfm"),
                                    ItemRowModel(R.drawable.photo_1, "Uzi", "dfhurirugiudfhgkjfhbjcfhjkhsdjkhfjsdhf")
                                )
                            ){ _, item ->
                                MyRow(item = item)
                            }
                        }
                    }
                }
            }
        }
    }
}

