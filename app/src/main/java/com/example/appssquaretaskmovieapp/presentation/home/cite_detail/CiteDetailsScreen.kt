package com.example.appssquaretaskmovieapp.presentation.home.cite_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.presentation.ui.theme.ButtonColor_Blue
import com.example.appssquaretaskmovieapp.presentation.ui.theme.ScreenBackground
import com.example.appssquaretaskmovieapp.presentation.ui.theme.TFColor
import com.example.appssquaretaskmovieapp.presentation.ui.theme.TextColor_Blue

@Composable
fun CiteDetailsScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBackground)
            .padding(horizontal = 20.dp, vertical = 42.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vector),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(38.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(ButtonColor_Blue)
                .padding(14.dp)
                .clickable {
                    navController.navigate("HOME")
                }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Image(
            painter = painterResource(id = R.drawable.img2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(271.dp),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Coeurdes Alpes",
                style = MaterialTheme.typography.labelLarge,
                fontSize = 22.sp,
            )
            Text(
                text = "355 Reviews",
                style = MaterialTheme.typography.labelSmall,
                color = TextColor_Blue,
                fontSize = 12.sp,
                modifier = Modifier.alpha(0.8f)
            )

        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and  Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and  Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and  Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and ........",
            style = MaterialTheme.typography.labelSmall,
            color = TFColor,
            fontSize = 12.sp,
            modifier = Modifier.alpha(0.8f),
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun CiteDetailsScreenPreview() {
    CiteDetailsScreen(rememberNavController())
}