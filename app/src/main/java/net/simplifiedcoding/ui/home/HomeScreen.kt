package net.simplifiedcoding.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.theme.spacing

@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing
    Box(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.reportbg1),
            contentScale = ContentScale.FillBounds)) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF732655),
                        contentColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text(text = "Login", fontSize = 19.sp)
                }

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    onClick = {
                        navController.navigate(ROUTE_SIGNUP) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF732655),
                        contentColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text(text = "Sign Up", fontSize = 19.sp)
                }
            }

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}

//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun HomeScreenPreviewDark() {
//    AppTheme {
//        HomeScreen(null, rememberNavController())
//    }
//}
