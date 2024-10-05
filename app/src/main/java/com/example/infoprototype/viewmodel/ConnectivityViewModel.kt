package com.example.infoprototype.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader

// UI State for the ViewModel to hold different states of testing
data class ConnectivityUIState(
    val isTesting: Boolean = false,
    val feedbackMessage: String = "Press Start Test to begin"
)

/**
 * Connectivity View Model:
 * - All business logic goes here.
 * - Presents an observable data for UI to observe
 */
class ConnectivityViewModel : ViewModel() {
    private val _uiState = mutableStateOf(ConnectivityUIState())
    val uiState = _uiState

    fun startTests() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = uiState.value.copy(isTesting = true, feedbackMessage = "Gathering Network Information...")
            val networkInfo = recordNetworkInformation()
            updateUI("Network Info: $networkInfo")

            _uiState.value = uiState.value.copy(feedbackMessage = "Running connectivity tests...")
            runConnectivityTests()
            updateUI("Connectivity Test Completed")

            _uiState.value = uiState.value.copy(feedbackMessage = "Collecting User Data...")
            // Assuming user data collected, send collected data
            sendCollectedData(networkInfo)
            updateUI("Data Sent Successfully")
            _uiState.value = uiState.value.copy(isTesting = false)
        }
    }

    private fun updateUI(message: String) {
        _uiState.value = uiState.value.copy(feedbackMessage = message)
    }

    private fun recordNetworkInformation(): String {
        // Logic to record network information
        // Placeholder: Replace with actual logic to get the set-top box network info
        return "Connectivity Type: WiFi"
    }

    private fun runConnectivityTests() {
        val pingResult = runPingTest("8.8.8.8")
        updateUI("Ping Test Result: $pingResult")
        // Simulate HTTP upload/download (Placeholder)
        val httpTestResult = "HTTP Download/Upload Success"
        updateUI(httpTestResult)
    }

    private fun sendCollectedData(networkInfo: String) {
        // Placeholder: Add logic for sending data to provided endpoint
        // Simulating sending data
        Thread.sleep(1000) // Replace with actual network operation
    }

    private fun runPingTest(ipAddress: String): String {
        return try {
            val process = Runtime.getRuntime().exec("ping -c 1 $ipAddress")
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            val result = StringBuilder()
            reader.lineSequence().forEach { result.append(it).append('\n') }
            reader.close()
            result.toString()
        } catch (e: Exception) {
            "Ping Failed"
        }
    }
}