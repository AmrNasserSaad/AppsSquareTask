package com.example.appssquaretaskmovieapp.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.appssquaretaskmovieapp.presentation.ui.theme.TFColor
import com.example.appssquaretaskmovieapp.presentation.ui.theme.TextColor_Blue

@Composable
fun AnnotatedStringWithTwoText(text1 : String, text2 : String , onClick:()->Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text1, color = TFColor,
            fontSize = 16.sp
        )
        Text(
            text = text2,
            color = TextColor_Blue,
            fontSize = 16.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .clickable {
                    onClick()
                }
        )
    }

}
