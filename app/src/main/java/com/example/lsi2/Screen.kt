package com.example.lsi2


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.io.File
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import com.example.lsi2.ui.theme.Purple40


private const val REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE = 34

private fun foregroundPermissionApproved(context: Context): Boolean {
    val writePermissionFlag = PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
        context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    val readPermissionFlag = PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
        context, android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    return writePermissionFlag && readPermissionFlag
}

private fun requestForegroundPermission(context: Context) {
    val provideRationale = foregroundPermissionApproved(context = context)
    if (provideRationale) {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE
        )
    }
    else{
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE
        )

    }
}
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
                                    .padding(top = 80.dp, bottom = 80.dp)
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
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img),
                                contentDescription = "image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(104.dp)
                                    .clip(CircleShape)
                            )

                            Text(text = "Guichir Rugiya", );

                            Spacer(modifier = Modifier.height(40.dp))

                            Text(text = "This is a short description and some information about this person. Some information about illness. Date of birth and etc.")

                            Spacer(modifier = Modifier.height(40.dp))

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
    val itemList = listOf(
        ItemRowModel(R.drawable.photo_1, "Dentistry"),
        ItemRowModel(R.drawable.photo_2, "Pharmacy"),
        ItemRowModel(R.drawable.photo_3, "Gynecology"),
        ItemRowModel(R.drawable.photo_4, "Pediatrics"),
        ItemRowModel(R.drawable.photo_5, "Primary care"),
        ItemRowModel(R.drawable.photo_6, "Optometry")
    )


    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    requestForegroundPermission(context)
    fun getDirectory(context: Context): File {
        val mediaDir = context.externalMediaDirs.firstOrNull()?.let {
            File(it, context.resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists()) mediaDir else context.filesDir
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = uri
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }
        context.startActivity(intent)
    }

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
                ClickableLazyRow(item = itemList)
            },

            confirmButton = {
                // Confirm button
                TextButton(
                    onClick = {
                        // Handle the confirmation action
                        generatePDF(context, getDirectory(context))
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

        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center)
        {
            Column(
            ) {

                Button(onClick = { showDialog = true }) {
                    Text("Выбрать врача")
                }

            Spacer(modifier = Modifier.height(35.dp))

                Button(onClick = {
                    launcher.launch(arrayOf("application/pdf"))
                }) {
                    Text("Open PDF", modifier = Modifier.padding(start = 10.dp))
                }
            }
    }
}

@Composable
fun ClickableLazyRow(item: List<ItemRowModel>) {
    var selectedIndex = remember { mutableStateOf(-1) }


    LazyRow (modifier = Modifier
        .fillMaxWidth()
    ){
        itemsIndexed(item) { index, item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 5.dp, 10.dp, 5.dp)
                    .wrapContentHeight(
                        align = CenterVertically
                    )
                    .selectable(
                        selected = selectedIndex.value == index,
                        onClick = {
                            selectedIndex.value = if (selectedIndex.value != index)
                                index else -1
                        }
                    )
                    .background(if (selectedIndex.value == index) Purple40 else Color.White,
                        shape = RoundedCornerShape(8.dp), )

            ) {
                MyRow(item = item)
            }
        }
    }
}








