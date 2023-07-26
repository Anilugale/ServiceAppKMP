import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.lifecycle.getNavigatorScreenLifecycleOwner
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.defaultNavigatorSaver
import dev.icerock.moko.media.compose.BindMediaPickerEffect
import dev.icerock.moko.media.compose.rememberMediaPickerControllerFactory
import dev.icerock.moko.media.compose.toImageBitmap
import dev.icerock.moko.media.picker.MediaSource
import info.mores.serviceapp.getPlatformName
import kotlinx.coroutines.launch

@Composable
fun App() {
    MaterialTheme {

        Scaffold (topBar = {
            TopAppBar (title = { Text(getPlatformName()) })
        },
            backgroundColor = Color(0xFFF2F2F2)

        ){
            Navigator(HomeScreen)
        }
    }
}


@Composable
fun ShowItem() {
    val navigator = LocalNavigator.currentOrThrow
    Card(Modifier.padding(10.dp).fillMaxWidth().clickable {
        navigator.push(PostListScreen())
    }) {
        Column(Modifier.padding(10.dp)) {
            Text("Primary text", style = MaterialTheme.typography.h6)
            Text("Secondary text",style = MaterialTheme.typography.body1)
        }
    }
}





object HomeScreen : Screen {

    @Composable
    override fun Content() {
        LazyColumn (Modifier.padding()){

            items(100){
                ShowItem()
            }
        }

    }
}

class PostListScreen : Screen {

    @Composable
    override fun Content() {
        val factory = rememberMediaPickerControllerFactory()
        val picker = remember(factory) { factory.createMediaPickerController() }
        val coroutineScope = rememberCoroutineScope()

        BindMediaPickerEffect(picker)

        var image: ImageBitmap? by remember { mutableStateOf(null) }

        image?.let {
            Image(bitmap = it, contentDescription = null)
        }

        Button(
            onClick = {
                coroutineScope.launch {
                    val result = picker.pickImage(MediaSource.GALLERY)
                    image = result.toImageBitmap()
                }
            }
        ) {
            Text(text = "Click on me")
        }
    }
}