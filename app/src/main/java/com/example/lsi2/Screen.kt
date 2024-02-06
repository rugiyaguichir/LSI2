package com.example.lsi2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
    Column {
        Image(
            painter = painterResource(id = R.drawable.logo2),
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
                text = "Find ID Number",
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
                    .background(Color.White),
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(645.dp),
                    shape = RoundedCornerShape(15.dp),
//                    elevation = 5.dp
                ) {
                    Box(modifier = Modifier
                        .padding(16.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 5.dp, top = 100.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Пожалуйста, введите ваш ИНН: ",
                                modifier = Modifier
                                    .padding(start = 5.dp, top = 10.dp)
                                    .fillMaxWidth(),
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp
                                )
                            )

                            var text by remember { mutableStateOf("") }

                            OutlinedTextField(
                                value = text,
                                onValueChange = { newText -> text = newText },
                                label = { Text("Enter text") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 80.dp,bottom = 80.dp)
                                    .height(70.dp),
                            )

                            Button(onClick = { navController.navigate("screen2") }) {
                                Text("ПОИСК")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Screen2() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.logo2),
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
                text = "Patient's personal INFO",
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
                        .height(645.dp),
                    shape = RoundedCornerShape(15.dp),
//                    elevation = 5.dp
                ) {
                    Box(modifier = Modifier
                        .padding(16.dp)
                    ) {
                        Column(modifier = Modifier
                            .padding(start = 30.dp, top = 20.dp)
                            .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.person_1),
                                contentDescription = "image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
//                                    .padding(20.dp)
                                    .size(104.dp)
                                    .clip(CircleShape)
                            )

                            Text(text = "Name and Surname");

                            Spacer(modifier = Modifier.height(30.dp))

                            Text(text = "This is a short description and some information about this person.")

                            Spacer(modifier = Modifier.height(30.dp))

                            DialogExample()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                // Handle the dismiss request (e.g., when the user clicks outside the dialog)
                showDialog = false
            },
            title = {
                Text("Выберите врача")
            },

            text = {
                // Composable for rows in the dialog
                LazyRow(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    itemsIndexed(
                        listOf(
                            ItemRowModel(R.drawable.photo_1, "Dentistry"),
                            ItemRowModel(R.drawable.photo_2, "Pharmacy"),
                            ItemRowModel(R.drawable.photo_3, "Gynecology"),
                            ItemRowModel(R.drawable.photo_4, "Pediatrics"),
                            ItemRowModel(R.drawable.photo_5, "Primary care"),
                            ItemRowModel(R.drawable.photo_6, "Optometry")
                        )
                    ){ _, item ->
                        MyRow(item = item)
                    }
                }
                // Add more rows as needed
            },
            confirmButton = {
                // Confirm button
                TextButton(
                    onClick = {
                        // Handle the confirmation action
                        showDialog = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                // Dismiss button
                TextButton(
                    onClick = {
                        // Handle the dismissal action
                        showDialog = false
                    }
                ) {
                    Text("Dismiss")
                }
            },
            modifier = Modifier.padding(16.dp)
        )
    }

    // Button to show the dialog
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Выбрать врача")
        }
    }
}



