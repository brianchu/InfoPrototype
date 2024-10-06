package com.example.infoprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.tv.material3.Button
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.example.infoprototype.ui.theme.TVConnectivityAppTheme
import com.example.infoprototype.viewmodel.ConnectivityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            TVConnectivityAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val viewModel: ConnectivityViewModel = viewModel()
    val uiState by remember { viewModel.uiState }

    var userInput by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = uiState.feedbackMessage,
                modifier = Modifier.padding(16.dp))

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                viewModel.startTests()
            }) {
                Text(
                    text = if (uiState.isTesting) "Testing" else "Start Test", fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            BasicTextField(value = userInput, onValueChange = {
                userInput = it
            }, modifier = Modifier.padding(16.dp))

            Button(onClick = {
                // ask viewModel to submit
            }) {
                Text(text = "Submit User Data", fontSize = 20.sp)
            }
        }
    }
}