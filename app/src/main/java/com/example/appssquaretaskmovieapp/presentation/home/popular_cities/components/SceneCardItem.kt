package com.example.appssquaretaskmovieapp.presentation.home.popular_cities.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.data.remote.cite.City
import com.example.appssquaretaskmovieapp.presentation.ui.theme.TextColor_Blue

@Composable
fun SceneCardItem(
    city: City,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = city.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp),
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = city.name,
                style = MaterialTheme.typography.labelLarge,
                fontSize = 18.sp,
            )
            Text(
                text = "${city.numberOfReviews} Reviews",
                style = MaterialTheme.typography.labelSmall,
                color = TextColor_Blue,
                fontSize = 12.sp,
                modifier = Modifier.alpha(0.8f),
            )
        }
    }

}
