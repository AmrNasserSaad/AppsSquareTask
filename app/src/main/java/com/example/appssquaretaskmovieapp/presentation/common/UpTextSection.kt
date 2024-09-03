package com.example.appssquaretaskmovieapp.presentation.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appssquaretaskmovieapp.R

@Composable
fun UpTextSection(text1 : String, text2 : String) {
    Text(
        text = text1,
        color = Black,
        fontSize = 36.sp,
        fontFamily = FontFamily(Font(R.font.inter_semibold))
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = text2,
        color = Black,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.inter_regular))
    )
}