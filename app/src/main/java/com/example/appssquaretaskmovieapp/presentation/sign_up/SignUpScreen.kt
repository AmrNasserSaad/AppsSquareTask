package com.example.appssquaretaskmovieapp.presentation.sign_up

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
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.presentation.components.AnnotatedStringWithTwoText
import com.example.appssquaretaskmovieapp.presentation.components.CommonButton
import com.example.appssquaretaskmovieapp.presentation.components.PasswordTextFieldWithText
import com.example.appssquaretaskmovieapp.presentation.components.TermsAndConditionsCheckbox
import com.example.appssquaretaskmovieapp.presentation.components.TextFieldWithText
import com.example.appssquaretaskmovieapp.presentation.components.UpTextSection
import com.example.appssquaretaskmovieapp.presentation.ui.theme.ScreenBackground

@Composable
fun SignUpScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBackground)
            .padding(horizontal = 24.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.Top
    ) {
        SignUpTopAppBarSection(navController)
        Spacer(modifier = Modifier.height(32.dp))
        UpTextSection("Sign Up", "Create your personal profile.com and follow.")
        Spacer(modifier = Modifier.height(24.dp))
        TextFieldWithText("Phone Number")
        Spacer(modifier = Modifier.height(18.dp))
        TextFieldWithText("Cite")
        Spacer(modifier = Modifier.height(18.dp))
        TextFieldWithText("Email")
        Spacer(modifier = Modifier.height(18.dp))
        PasswordTextFieldWithText(text = "Password")
        Spacer(modifier = Modifier.height(8.dp))
        TermsAndConditionsCheckbox()
        Spacer(modifier = Modifier.height(28.dp))
        CommonButton(text = " Sign Up") {
            navController.navigate("LOGIN")
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnnotatedStringWithTwoText("Already have an account? ", "Login"){
            navController.navigate("LOGIN")
        }


    }
}


@Composable
fun SignUpTopAppBarSection(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = null,
            modifier = Modifier.clickable {
                navController.navigate("LOGIN")
            }
        )
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
private fun SignUpScreenPreview() {
    SignUpScreen(rememberNavController())
}