package info.mores.serviceapp

import App
import androidx.compose.ui.window.ComposeUIViewController

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }