package com.codepuligal.xdcfin

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun splashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8620FF))
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "XDC Finance",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .animateContentSize()
            )
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(64.dp)
                    .animateContentSize()
            )

            LaunchedEffect(Unit) {
                delay(2000) // Delay for 2 seconds
                navController.navigate("home") // Navigate to the home screen
            }
        }
    }
}