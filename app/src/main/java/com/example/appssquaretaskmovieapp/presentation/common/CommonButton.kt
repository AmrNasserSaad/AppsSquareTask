package com.example.appssquaretaskmovieapp.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appssquaretaskmovieapp.presentation.ui.theme.ButtonColor_Blue

@Composable
fun CommonButton(text : String , onClick : ()-> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor_Blue),
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
private fun CommonButtonPreview() {
    CommonButton(text = "Explore" ) {}
}