package com.example.appssquaretaskmovieapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.presentation.common.AnnotatedStringWithTwoText
import com.example.appssquaretaskmovieapp.presentation.common.CommonButton
import com.example.appssquaretaskmovieapp.presentation.common.PasswordTextFieldWithText
import com.example.appssquaretaskmovieapp.presentation.common.TextFieldWithText
import com.example.appssquaretaskmovieapp.presentation.common.UpTextSection
import com.example.appssquaretaskmovieapp.presentation.ui.theme.ScreenBackground

@Composable
fun LoginScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBackground)
            .padding(horizontal = 24.dp, vertical = 46.dp),
        verticalArrangement = Arrangement.Top
    ) {

        LoginTopAbbBar()
        Spacer(modifier = Modifier.height(32.dp))
        UpTextSection("Login", "Enter to your personal profile.com and follow.")
        Spacer(modifier = Modifier.height(24.dp))
        TextFieldWithText("Email")
        Spacer(modifier = Modifier.height(18.dp))
        PasswordTextFieldWithText(text = "Password")
        Spacer(modifier = Modifier.height(32.dp))
        CommonButton(text = " Login") {
            navController.navigate("HOME")
        }
        Spacer(modifier = Modifier.height(38.dp))
        AnnotatedStringWithTwoText("Don’t have an account yet? ", "Sign Up"){
            navController.navigate("SIGN_UP")
        }


    }
}

@Composable
private fun LoginTopAbbBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.weight(0.5f))

    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}