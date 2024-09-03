package com.example.appssquaretaskmovieapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.presentation.ui.theme.TextColor_Blue

@Composable
fun TermsAndConditionsCheckbox() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = TextColor_Blue,
                uncheckedColor = TextColor_Blue,
            )
        )

        // A Row to keep the text side by side
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                text = "By signing up, you agree to the Terms of "
            )
            Text(
                text = " Service and Privacy Policy",
                color = TextColor_Blue,
                fontSize = 16.sp,
                modifier = Modifier
                    .clickable {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TermsAndConditionsCheckboxPreview() {
    TermsAndConditionsCheckbox()
}
