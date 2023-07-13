package net.simplifiedcoding.ui.report

import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_LATESTREPORTSCREEN
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_MENU
import net.simplifiedcoding.navigation.ROUTE_MENUONE
import net.simplifiedcoding.navigation.ROUTE_REPORT
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(viewModel: AuthViewModel?, navController: NavHostController) {

    // Write a message to the database
    val database = Firebase.database
    val myRef = database.getReference("message")





    var name by remember { mutableStateOf( TextFieldValue()) }
//    var age by remember { mutableStateOf("") }
    var lastseenlocation by remember { mutableStateOf(TextFieldValue()) }
    var lastseendate by remember { mutableStateOf(TextFieldValue()) }
    var contact by remember { mutableStateOf(TextFieldValue()) }

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        selectedImageUri = uri
    }

    val reportData = mapOf(
        "name" to name.text,
        "lastseenlocation" to lastseenlocation.text,
        "lastseendate" to lastseendate.text,
        "contact" to contact.text
    )



    Column(modifier = Modifier.fillMaxSize()) {
        SmallTopAppBar (title = {Text(text = "Enter Person Details",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = (Color(0xFFD8CFD2)),
            modifier = Modifier.fillMaxWidth())},
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF732655)),

            navigationIcon = {
                IconButton(onClick = { /*TODO*/
                    navController.navigate(ROUTE_MENU){
                        popUpTo(ROUTE_REPORT) { inclusive = true }
                    }
                })
                {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = (Color(0xFFD8CFD2)))

                }
            }
            )


    Box(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.reportbg1), contentScale = ContentScale.FillBounds)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .wrapContentSize(Alignment.Center)
        ){
            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(180.dp)
                        .background(Color.LightGray)
                        .border(
                            2.dp,
                            color = Color(0xFF732655)
                        )
                        .clip(RoundedCornerShape(15.dp))
                        .clickable { launcher.launch("image/*") },
                    contentAlignment = Alignment.Center
                ) {
                    val placeholderText = if (selectedImageUri != null) {
                        "Image Selected"
                    } else {
                        "Upload Image"
                    }
                    Text(
                        text = placeholderText,
                        style = MaterialTheme.typography.titleMedium,
                        color = LocalContentColor.current.copy(alpha = 0.6f),
                    )
                }

                Text(text = "",
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    color = Color(0xFFD8CFD2), fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.height(10.dp))


                OutlinedTextField(modifier = Modifier,
                    shape = RoundedCornerShape(10.dp),
                    label = { Text (text = "Names") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF732655),
                        unfocusedBorderColor = Color(0xFF4C4162)
                    ),
                    leadingIcon = { Icon(painterResource(id = R.drawable.baseline_person_24), contentDescription = null )},
                    value = name,
                    onValueChange = { name = it })


                Spacer(modifier = Modifier.height(10.dp))

//                OutlinedTextField(
//                    shape = RoundedCornerShape(10.dp),
//                    label = { Text(text = "Age") },
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedBorderColor = Color(0xFF732655),
//                        unfocusedBorderColor = Color(0xFF4C4162)
//                    ),
//                    value = age,
//                    onValueChange = { age = it })
//
//                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(modifier = Modifier,
                    shape = RoundedCornerShape(10.dp),
                    label = { Text (text = "Last Seen Location") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF732655),
                        unfocusedBorderColor = Color(0xFF4C4162)
                    ),
                    leadingIcon = { Icon(painterResource(id = R.drawable.baseline_add_location_24), contentDescription = null )},
                    value = lastseenlocation,
                    onValueChange = { lastseenlocation = it })

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    modifier = Modifier,
                    shape = RoundedCornerShape(10.dp),
                    label = { Text (text = "Last Seen Date") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF732655),
                        unfocusedBorderColor = Color(0xFF4C4162)
                    ),
                    leadingIcon = { Icon(painterResource(id = R.drawable.baseline_date_range_24), contentDescription = null )},
                    value = lastseendate,
                    onValueChange = { lastseendate = it })

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    shape = RoundedCornerShape(10.dp),
                    label = { Text(text = "Contact") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF732655),
                        unfocusedBorderColor = Color(0xFF4C4162)
                    ),
                    value = contact,
                    leadingIcon = { Icon(painterResource(id = R.drawable.baseline_contact_phone_24), contentDescription = null )},
                    onValueChange = { contact = it })

                Spacer(modifier = Modifier.height(30.dp))

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = { myRef.setValue(reportData)
                            navController.navigate(ROUTE_LATESTREPORTSCREEN) {
                                popUpTo(ROUTE_REPORT) { inclusive = true }
                            }
                        },

                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .width(400.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF732655).copy(alpha = 0.5f),
                            contentColor = Color(0xFFFFFFFF)),
                    ) {
                        Text(text = "Post", fontSize = 17.sp)
                    }
                }

            }
        }
    }
}
}



@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ReportScreenPreviewLight() {
    AppTheme {
        ReportScreen(null, rememberNavController())
    }
}

//@Preview(showBackground = false, uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun ReportScreenPreviewDark() {
//    AppTheme {
//        ReportScreen(null, rememberNavController())
//    }
//}
