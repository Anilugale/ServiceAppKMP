package info.mores.serviceapp

import App
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import dev.icerock.moko.media.picker.MediaPickerController
import dev.icerock.moko.permissions.PermissionsController


@Composable fun MainView() = App()


actual fun getPlatformName(): String = "Android"
