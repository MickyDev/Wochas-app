package net.simplifiedcoding.ui

import android.content.res.Configuration
import android.window.SplashScreen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.ui.auth.AuthViewModel

@Composable
fun AnimatedSplashScreen(viewModel: AuthViewModel?, navController: NavHostController){

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.family))
    var isPlaying by remember { mutableStateOf(true) }

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )

    LaunchedEffect(key1 = progress){
        delay(3000)
        navController.popBackStack()
        navController.navigate(ROUTE_HOME)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF732655)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        LottieAnimation(
            modifier = Modifier
                .size(650.dp),

            composition = composition,
        progress = {progress}
        )
    }
}

@Composable
fun Splash(alpha: Float){

    Box(
        modifier = Modifier
            .background(Color(0xFF732655))
            .fillMaxSize()
            .alpha(alpha = alpha),
        contentAlignment = Alignment.Center
    ){

    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun SplashScreenPreview(){
    Splash(alpha = 1f)
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun SplashScreenDarkPreview(){
    Splash(alpha = 1f)
}