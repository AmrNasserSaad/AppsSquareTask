package com.example.appssquaretaskmovieapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.presentation.common.CommonButton

@Composable
fun SplashScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_img),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )

        // Center the "Aspen" text at the top
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 64.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "Aspen",
                fontFamily = FontFamily(Font(R.font.hiatus)),
                color = Color.White,
                fontSize = 106.sp,
            )
        }

        // Align the rest of the content at the start (left-aligned)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical = 56.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.weight(7f))
            Text(
                text = "Plan your",
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                color = Color.White,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Luxurious \n \nVacation",
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                color = Color.White,
                fontSize = 32.sp,
            )
            Spacer(modifier = Modifier.height(16.dp))

            CommonButton(text = "Explore") {
                navController.navigate("LOGIN")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}
