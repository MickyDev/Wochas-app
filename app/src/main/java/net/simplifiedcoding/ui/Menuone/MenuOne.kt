package net.simplifiedcoding.ui.Menuone

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_MENUONE
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.theme.spacing

@Composable
fun MenuOneScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF000000).copy(alpha = 0.5f)) // Add dark opacity to the background
    ) {
    Box(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.afriman),
            contentScale = ContentScale.FillHeight)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .background(Color.Transparent)
                .padding(bottom = 35.dp)
                .align(Alignment.BottomCenter)
        ) {

            Text(
                text = "Help the community to find our lost loved ones.",
                modifier = Modifier
                    .padding(top = 150.dp), // Add top padding
                color = Color.White,
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )

            Box(Modifier.weight(1f)) {
                // Add Spacer to push the buttons to the bottom
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_MENUONE) { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .weight(1f) // Occupy equal space in the row
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF732655).copy(alpha = 0.5f),
                        contentColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text(text = "Login", fontSize = 19.sp)
                }

                Spacer(modifier = Modifier.width(16.dp)) // Add spacing between the buttons

                Button(
                    onClick = {
                        navController.navigate(ROUTE_SIGNUP) {
                            popUpTo(ROUTE_MENUONE) { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .weight(1f) // Occupy equal space in the row
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF732655).copy(alpha = 0.5f),
                        contentColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text(text = "Sign Up", fontSize = 19.sp)
                }
            }
        }
    }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MenuOneScreenPreviewLight() {
    AppTheme {
        MenuOneScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MenuOneScreenPreviewDark() {
    AppTheme {
        MenuOneScreen(null, rememberNavController())
    }
}
