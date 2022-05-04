package com.samples.factorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.samples.factorial.ui.theme.FactorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FactorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Factorial()
                }
            }
        }
    }
}


@Composable
fun Factorial(){
    // expanded state determines the value based on dropdown selection
    var expanded by remember { mutableStateOf(false) }

    //text state determines the value based on dropdown init and dropdown item click.
    var text by remember {
        mutableStateOf(factorialAsString(0))
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        Text(
            modifier = Modifier.clickable { expanded = true },
            text = text,
            style = MaterialTheme.typography.h2
            )
        DropdownMenu(expanded = expanded,
            onDismissRequest = {
            expanded = false
        }) {
            for (n in 0 until 10){
                DropdownMenuItem(onClick = {
                    expanded = false
                    text = factorialAsString(n)
                }) {
                    Text("${n.toString()}!")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FactorialTheme {
        Factorial()
    }
}

fun factorialAsString(n : Int): String{
    var result = 1L;
    for (i in 1..n){
        result *=i
    }
    return "$n! = $result"
}