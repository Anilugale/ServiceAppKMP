package info.mores.serviceapp

import App
import androidx.compose.runtime.Composable


@Composable fun MainView() = App()


actual fun getPlatformName(): String = "Android"
