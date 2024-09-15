package com.example.appssquaretaskmovieapp.presentation.sign_up

import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appssquaretaskmovieapp.R
import com.example.appssquaretaskmovieapp.data.remote.register.SignUpRequest
import com.example.appssquaretaskmovieapp.presentation.common.AnnotatedStringWithTwoText
import com.example.appssquaretaskmovieapp.presentation.common.CommonButton
import com.example.appssquaretaskmovieapp.presentation.common.PasswordTextFieldWithText
import com.example.appssquaretaskmovieapp.presentation.common.TermsAndConditionsCheckbox
import com.example.appssquaretaskmovieapp.presentation.common.TextFieldWithText
import com.example.appssquaretaskmovieapp.presentation.common.UpTextSection
import com.example.appssquaretaskmovieapp.presentation.ui.theme.ScreenBackground

@Composable
fun SignUpScreen(
    navController: NavController
) {
    val viewModel: SignUpViewModel = hiltViewModel()
    val signUpResult by viewModel.signUpResult.collectAsState()
    val context = LocalContext.current

    // State variables for user input
    var phoneNumber by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Handle the observed sign-up result
    signUpResult?.let { result ->
        result.onSuccess {
            // Navigate to login or show a success message
            LaunchedEffect(Unit) {
                Toast.makeText(context, "Success: Signed Up", Toast.LENGTH_LONG).show()
                navController.navigate("LOGIN")
            }
        }.onFailure { error ->
            // Show error message
            Toast.makeText(context, "${error.message} : $result  ", Toast.LENGTH_LONG).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBackground)
            .padding(horizontal = 24.dp, vertical = 42.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top
    ) {
        SignUpTopAppBarSection(navController)
        Spacer(modifier = Modifier.height(32.dp))
        UpTextSection(text1 = "Sign Up", text2 = "Create your personal profile and follow.")

        Spacer(modifier = Modifier.height(24.dp))
        TextFieldWithText(
            label = "Phone Number",
            value = phoneNumber,
            onValueChange = { phoneNumber = it }
        )

        Spacer(modifier = Modifier.height(18.dp))
        TextFieldWithText(
            label = "City",
            value = city,
            onValueChange = { city = it }
        )

        Spacer(modifier = Modifier.height(18.dp))
        TextFieldWithText(
            label = "Email",
            value = email,
            onValueChange = { email = it }
        )

        Spacer(modifier = Modifier.height(18.dp))
        PasswordTextFieldWithText(
            label = "Password",
            password = password,
            onPasswordChange = { password = it },
            passwordVisible = passwordVisible,
            onPasswordVisibilityChange = { passwordVisible = !passwordVisible }
        )

        Spacer(modifier = Modifier.height(8.dp))
        TermsAndConditionsCheckbox()

        Spacer(modifier = Modifier.height(28.dp))
        CommonButton(text = "Sign Up") {
            // Trigger sign-up when the button is clicked
            viewModel.signUp(
                SignUpRequest(
                    name = "amr",
                    phone = phoneNumber,
                    city = city,
                    email = email,
                    password = password
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        AnnotatedStringWithTwoText(
            text1 = "Already have an account? ",
            text2 = "Login"
        ) {
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
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen(rememberNavController())
}
