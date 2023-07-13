package net.simplifiedcoding.ui.latest

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import net.simplifiedcoding.navigation.ROUTE_LATESTREPORTSCREEN
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_MENU
import net.simplifiedcoding.navigation.ROUTE_REPORT
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.ui.Menu.MenuScreen
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.latest.PersonListItem
import net.simplifiedcoding.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LatestReportScreen(viewModel: AuthViewModel?, navController: NavHostController) {
Column(modifier = Modifier
    .fillMaxSize()
    .background(Color(0xFFD8CFD2))) {
    SmallTopAppBar (title = {Text(text = "Missing Persons",
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        color = Color(0xFF732655),
        modifier = Modifier.fillMaxWidth())},
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = (Color(0xFFFFB4AB).copy(alpha = 0.3f))),

        navigationIcon = {
            IconButton(onClick = { /*TODO*/
                navController.navigate(ROUTE_MENU){
                    popUpTo(ROUTE_LATESTREPORTSCREEN) { inclusive = true }
                }
            })
            {
                Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color(0xFF732655))

            }
//            Button(
//                onClick = {
//                    viewModel?.logout()
//                    navController.navigate(ROUTE_LOGIN) {
//                        popUpTo(ROUTE_HOME) { inclusive = true }
//                    }
//                },
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(top = spacing.extraLarge)
//            ) {
//                Text(text = "Logout")
//            }

        }
    )


        PersonContent()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate(ROUTE_REPORT) {
                    popUpTo(ROUTE_LATESTREPORTSCREEN) { inclusive = true }
                }
            },
            modifier = Modifier
                .size(72.dp)
                .padding(16.dp)
                .background(Color.Blue, RoundedCornerShape(50)),
            contentColor = Color.White
        ) {
            // Add button content here
        }
    }


}
}



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LatestReportScreenPreviewLight() {
    AppTheme {
        LatestReportScreen(null, rememberNavController())
    }
}

//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun LatestReportScreenPreviewDark() {
//    AppTheme {
//        LatestReportScreen(null, rememberNavController())
//    }
//}