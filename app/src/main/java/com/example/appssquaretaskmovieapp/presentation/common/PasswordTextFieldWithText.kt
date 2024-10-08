package com.example.appssquaretaskmovieapp.presentation.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.presentation.ui.theme.TFColor

@Composable
fun PasswordTextFieldWithText(
    label: String,
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onPasswordVisibilityChange: () -> Unit
) {
    Column {
        Text(
            text = label,
            color = Black,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter_medium))
        )

        Spacer(modifier = Modifier.height(2.dp))

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            shape = RoundedCornerShape(12.dp),
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = White,
                unfocusedBorderColor = White,
                unfocusedContainerColor = White,
                focusedContainerColor = White,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            label = { Text(text = label, color = TFColor) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = onPasswordVisibilityChange) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_show_password),
                        contentDescription = null,
                        tint = TFColor
                    )
                }
            }
        )
    }
}


