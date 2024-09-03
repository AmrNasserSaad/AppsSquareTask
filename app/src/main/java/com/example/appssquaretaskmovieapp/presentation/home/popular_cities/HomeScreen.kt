package com.example.appssquaretaskmovieapp.presentation.home.popular_cities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.presentation.home.popular_cities.components.DataSource
import com.example.appssquaretaskmovieapp.presentation.home.popular_cities.components.SceneCardItem
import com.example.appssquaretaskmovieapp.presentation.ui.theme.ScreenBackground

@Composable
fun HomeScreen(
    navController: NavController
) {
    val imageCards = DataSource().getCardData()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBackground)
            .padding(horizontal = 20.dp, vertical = 42.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(124.dp),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Popular Cities",
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.inter_semibold))
            )
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                items(imageCards.size) { index ->
                    SceneCardItem(imageCard = imageCards[index]) {
                        navController.navigate("CiteDetailsScreen")
                    }
                    Spacer(modifier = Modifier.height(22.dp))
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}