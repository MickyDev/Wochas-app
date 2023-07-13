package net.simplifiedcoding.ui.Menu

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_LATESTREPORTSCREEN
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_MENU
import net.simplifiedcoding.navigation.ROUTE_REPORT
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.theme.spacing

@Composable
fun MenuScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFD8CFD2))
        .paint(painterResource(id = R.drawable.menuonebg), contentScale = ContentScale.FillBounds)) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {

                Spacer(modifier = Modifier.width(300.dp))


            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {


                Button(
                    onClick = {
                        navController.navigate(ROUTE_LATESTREPORTSCREEN) {
                            popUpTo(ROUTE_MENU) { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .width(160.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFB4AB).copy(alpha = 0.3f))
                ) {
                    Text(text = "Latest Reports", fontSize = 19.sp, textAlign = TextAlign.Center)
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = {
                        navController.navigate(ROUTE_REPORT) {
                            popUpTo(ROUTE_MENU) { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .width(160.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFB4AB).copy(alpha = 0.3f))
                ) {
                    Text(text = "Make a Report", fontSize = 19.sp, textAlign = TextAlign.Center)
                }
            }
        }
        ClickableText(
            text = buildAnnotatedString { append("Logout") },
            onClick = { offset ->
                if (offset in 0 until "Logout".length) {
                    viewModel?.logout()
                    navController.navigate(ROUTE_LOGIN) {
                        popUpTo(ROUTE_HOME) { inclusive = true }
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .padding(top = spacing.extraLarge)
        )
    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MenuScreenPreviewLight() {
    AppTheme {
        MenuScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MenuScreenPreviewDark() {
    AppTheme {
        MenuScreen(null, rememberNavController())
    }
}
