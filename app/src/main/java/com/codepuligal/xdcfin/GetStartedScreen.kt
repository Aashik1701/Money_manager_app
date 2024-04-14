package com.codepuligal.xdcfin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun getStarted(
    navController: NavHostController
) {
    val onGetStartedClick = remember {
        { navController.navigate("home") } // Navigate to signup screen on button click
    }
    val modifier = Modifier

    Surface(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(16.dp),
        color = Color.White
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Image goes here
                Image(
                    painter = painterResource(R.drawable.your_onboarding_image),
                    contentDescription = stringResource(R.string.onboarding_image_description)
                )

                // Punchline Text with custom style
                Text(
                    text = stringResource(R.string.onboarding_punchline),
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 38.sp, // Adjust line height if needed,
                    letterSpacing = (-0.02).em, // Adjust letter spacing if needed,
                    color = Color(0xFF438883) // Color from hex code
                )

                // Get Started Button
                Button(
                    onClick = onGetStartedClick,
                    modifier = Modifier.padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.White)
                ) {
                    Text(text = stringResource(R.string.get_started))
                }

            }
        }
    }
}

