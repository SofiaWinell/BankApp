package com.dsw.pam.bank_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dsw.pam.bank_app.R

@Preview
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 18.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Log in",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = "Who am I? Obama is real",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Red
            )

            Text(
                text = "Who am I? Obama is real",
                style = MaterialTheme.typography.titleMedium,
            )

            Image(
                painter = painterResource(
                    id = R.drawable.mobile_login_rafiki
                ),
                contentDescription = "Login image",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(200.dp)
            )

            var login by remember {
                mutableStateOf("")
            }

            var password by remember {
                mutableStateOf("")
            }

            var passwordVisible by remember {
                mutableStateOf(false)
            }

            OutlinedTextField(
                value = login,
                onValueChange = { login = it },
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(text = "Login", color = Color.LightGray)
                },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()

            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(text = "Password", color = Color.LightGray)
                },
                maxLines = 1,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()

            )
        }
    }

}