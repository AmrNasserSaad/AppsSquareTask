package com.example.appssquaretaskmovieapp.presentation.home.popular_cities.components

import androidx.annotation.DrawableRes
import com.example.appssquaretaskmovieapp.R


class ImageCard(
    val name: String,
    val reviews: String,
    @DrawableRes val picture: Int
)

class DataSource {
    fun getCardData(): List<ImageCard> {

        val card = mutableListOf<ImageCard>()

        card.add(
            ImageCard(
                name = "Courdes Alpes ",
                reviews = "355 Reviews",
                R.drawable.img3,
            )
        )
        card.add(
            ImageCard(
                name = "Courdes Alpes ",
                reviews = "355 Reviews",
                R.drawable.img2,
            )
        )
        card.add(
            ImageCard(
                name = "Courdes Alpes ",
                reviews = "355 Reviews",
                R.drawable.img1,
            )
        )

        return card
    }

}
