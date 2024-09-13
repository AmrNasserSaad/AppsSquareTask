package com.example.appssquaretaskmovieapp.presentation.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
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
import com.example.appssquaretaskmovieapp.data.remote.register.LoginRequest
import com.example.appssquaretaskmovieapp.presentation.common.*
import com.example.appssquaretaskmovieapp.presentation.ui.theme.ScreenBackground

@Composable
fun LoginScreen(
    navController: NavController
) {
    val viewModel: LoginViewModel = hiltViewModel()
    val loginResult by viewModel.loginResult.collectAsState()
    val context = LocalContext.current

    // State variables for user input
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Handle the observed login result
    loginResult?.let { result ->
        result.onSuccess {
            // Navigate to home or show a success message
            LaunchedEffect(Unit) {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
                navController.navigate("HOME")
            }
        }.onFailure { error ->
            // Show error message
            Toast.makeText(context, "Error: ${error.message} $result", Toast.LENGTH_LONG).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBackground)
            .padding(horizontal = 24.dp, vertical = 46.dp),
        verticalArrangement = Arrangement.Top
    ) {
        LoginTopAppBar()
        Spacer(modifier = Modifier.height(32.dp))
        UpTextSection(text1 = "Login", text2 = "Enter your personal profile and follow.")

        Spacer(modifier = Modifier.height(24.dp))
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

        Spacer(modifier = Modifier.height(32.dp))
        CommonButton(text = "Login") {
            // Trigger login when the button is clicked
            viewModel.login(LoginRequest(email = email, password = password))
        }

        Spacer(modifier = Modifier.height(38.dp))
        AnnotatedStringWithTwoText(
            text1 = "Don’t have an account yet? ",
            text2 = "Sign Up"
        ) {
            navController.navigate("SIGN_UP")
        }
    }
}

@Composable
private fun LoginTopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
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
private fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
