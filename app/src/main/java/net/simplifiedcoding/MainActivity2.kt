//package net.simplifiedcoding
//
//import android.content.res.Configuration
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import kotlinx.coroutines.delay
//import net.simplifiedcoding.navigation.ROUTE_HOME
//import net.simplifiedcoding.ui.auth.AuthViewModel
//
//import net.simplifiedcoding.ui.ui.theme.FirebaseAuthTheme
//
//class MainActivity2 : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//
//        }
//    }
//}
//
//@Composable
//fun AnimatedSplashScreen(viewModel: AuthViewModel?, navController: NavHostController){
//    var startAnimation by remember {  mutableStateOf(false) }
//    val alphaAnimation = animateFloatAsState(
//        targetValue = if (startAnimation) 1f else 0f,
//        animationSpec = tween(
//            durationMillis = 3000)
//    )
//
//
//
//    LaunchedEffect(key1 = true){
//        startAnimation = true
//        delay(4000)
//        navController.popBackStack()
//        navController.navigate(ROUTE_HOME)
//    }
//    Splash(alpha = alphaAnimation.value)
//
//}
//
//@Composable
//fun Splash(alpha: Float){
//
//    Box(
//        modifier = Modifier
//            .background(Color.Cyan)
//            .fillMaxSize()
//            .alpha(alpha = alpha),
//        contentAlignment = Alignment.Center
//    ){
//        Icon(
//            modifier =Modifier.size(120.dp),
//            imageVector = Icons.Default.Email,
//            contentDescription = "Logo image")
//    }
//}
//
//@Composable
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//fun SplashScreenPreview(){
//    Splash(alpha = 1f)
//}
//
//@Composable
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//fun SplashScreenDarkPreview(){
//    Splash(alpha = 1f)
//}