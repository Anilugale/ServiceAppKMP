import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import info.mores.serviceapp.getPlatformName

@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }

        Scaffold (topBar = {
            TopAppBar (title = { Text(getPlatformName()) })
        },
            backgroundColor = Color(0xFFF2F2F2)

        ){

            LazyColumn (Modifier.padding(it)){

                items(100){
                    ShowItem()
                }


            }


        }
    }
}


@Composable
fun ShowItem() {
    Card(Modifier.padding(10.dp).fillMaxWidth()) {
        Column(Modifier.padding(10.dp)) {
            Text("Primary text", style = MaterialTheme.typography.h6)
            Text("Secondary text",style = MaterialTheme.typography.body1)
        }




    }
}

