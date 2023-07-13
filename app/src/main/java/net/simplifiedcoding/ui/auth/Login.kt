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
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.data.Resource
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_MENU
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: AuthViewModel?, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loginFlow = viewModel?.loginFlow?.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFBDEBC))
//            .paint(painterResource(id = R.drawable.loginbg), contentScale = ContentScale.FillBounds)
    )
     {

    }

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(145.dp))
        Text(
            text = "Login",
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            color = Color(0xFF732655),
            fontWeight = FontWeight.Bold
        )


        Spacer(modifier = Modifier.height(70.dp))

        OutlinedTextField(modifier = Modifier,
            shape = RoundedCornerShape(27.dp),
            label = { Text(text = "Enter your email address") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF732655),
                unfocusedBorderColor = Color(0xFF4C4162)),
            value = email,
            onValueChange = { email = it })

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(27.dp),
            label = { Text(text = "Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF732655),
                unfocusedBorderColor = Color(0xFF4C4162)),
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password = it })

        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    viewModel?.login(email, password)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF732655),
                    contentColor = Color(0xFFFFFFFF)),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }

//        Spacer(modifier = Modifier.height(20.dp))
//        ClickableText(
//            text = AnnotatedString("Forgot password?"),
//            onClick = { },
//            style = TextStyle(
//                fontSize = 14.sp,
//            )
//        )
        Spacer(modifier = Modifier.height(40.dp))
        ClickableText(
            text = AnnotatedString("Sign Up?"),
            onClick = {
                navController.navigate(ROUTE_SIGNUP){
                    popUpTo(ROUTE_LOGIN) { inclusive = true }
                }
            },
            style = TextStyle(
                fontSize = 14.sp,
            )
        )
    }


        loginFlow?.value?.let {
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
                            modifier = Modifier
                                .size(32.dp),
                            color = Color(0xFF732655)
                        )
                    }
                }
                is Resource.Success -> {
                    LaunchedEffect(Unit) {
                        navController.navigate(ROUTE_MENU) {
                            popUpTo(ROUTE_LOGIN) { inclusive = true }
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
fun LoginScreenPreviewLight() {
    AppTheme {
        LoginScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreviewDark() {
    AppTheme {
        LoginScreen(null, rememberNavController())
    }
}
