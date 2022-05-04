package com.samples.init

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samples.init.ui.theme.InitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Hello()
                }
            }
        }
    }
}

@Composable
fun TextAndButton(name:MutableState<String>,nameEntered:MutableState<Boolean>){
    Row(modifier = Modifier.padding(top = 8.dp)) {
        Button(modifier = Modifier
            .alignByBaseline()
            .padding(8.dp),
            onClick = { nameEntered.value = true }) {
            Text(text = "Done")
        }
        TextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            placeholder = {
                Text(text = "Welcome.Whats your Address?")
            },
            modifier = Modifier
                .alignByBaseline()
                .weight(1.0F),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Words,
            ),
            keyboardActions = KeyboardActions(onAny = {
                nameEntered.value = true
            })
        )
    }
}

@Composable
fun Hello(){
    val name = remember{ mutableStateOf("")}
    val nameEntered = remember { mutableStateOf(false)}
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (nameEntered.value){
            Greeting(name.value)
        }
        else{
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Welcome()
                TextAndButton(name, nameEntered)
            }
        }
    }
}

@Composable
fun Welcome(){
    Text(
        text = "Welcome",
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
}

@Preview(showBackground = true, group = "first-group")
@Composable
fun DefaultPreview() {
    InitTheme {
        Hello()
    }
}