package net.simplifiedcoding.ui.auth

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.data.Resource
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    val signupFlow = viewModel?.signupFlow?.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFBDEBC))
//        .paint(painterResource(id = R.drawable.signupbg), contentScale = ContentScale.FillBounds)
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


        Text(text = "CREATE YOUR ACCOUNT",
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            color = Color(0xFF732655), fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier
            .height(80.dp))


        OutlinedTextField(modifier = Modifier,
            shape = RoundedCornerShape(27.dp),
            label = { Text (text = "Your name") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF732655),
                unfocusedBorderColor = Color(0xFF4C4162)),
            leadingIcon = { Icon(Icons.Filled.Face, contentDescription = null )},
            value = name,
            onValueChange = { name = it })

        Spacer(modifier = Modifier.height(10.dp))


        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier,
            shape = RoundedCornerShape(27.dp),
            label = { Text (text = "Your Email Address") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF732655),
                unfocusedBorderColor = Color(0xFF4C4162)),
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null )},
            value = email,
            onValueChange = { email = it })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(27.dp),
            label = { Text(text = "Create Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF732655),
                unfocusedBorderColor = Color(0xFF4C4162)),
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = { Icon(painterResource(id = R.drawable.baseline_password_24), contentDescription = null )},
            onValueChange = { password = it })

        Spacer(modifier = Modifier.height(80.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    viewModel?.signup(name, email, password)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF732655),
                    contentColor = Color(0xFFFFFFFF)),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Submit")
            }
        }

        Spacer(modifier = Modifier.height(70.dp))

        Text(text = "Click here if you already have an account",
            modifier = Modifier
                .clickable {
                    navController.navigate(ROUTE_LOGIN) {
                        popUpTo(ROUTE_SIGNUP) { inclusive = true }
                    }
                }
        )

    }
        }


    }

        signupFlow?.value?.let {
            when (it) {
                is Resource.Failure -> {
                    val context = LocalContext.current
                    Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
                }
                Resource.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(32.dp),
                            color = Color(0xFF732655)
                        )
                    }
                }
                is Resource.Success -> {
                    LaunchedEffect(Unit) {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_SIGNUP) { inclusive = true }
                        }
                    }
                }

                else -> {}
            }
        }

//    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun SignupScreenPreviewLight() {
    AppTheme {
        SignupScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SignupScreenPreviewDark() {
    AppTheme {
        SignupScreen(null, rememberNavController())
    }
}
