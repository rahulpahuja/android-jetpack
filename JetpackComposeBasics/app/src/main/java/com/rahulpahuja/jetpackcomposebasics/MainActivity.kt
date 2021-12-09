package com.rahulpahuja.jetpackcomposebasics
//https://youtu.be/qvDo0SKR8-k

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahulpahuja.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp(){
                Greeting(name = "Android")
            }
            Greeting(name = "Android")

        }
    }
}

@Composable
fun Counter(count:Int,updateCount:(Int)->Unit) {

        Button(onClick = { updateCount(count+1) }) {
            Text(text = "I've been clicked $count times")
        }

}


@Composable
fun MyApp(content: @Composable () -> Unit){
    JetpackComposeBasicsTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            MyScreenContent()
        }
    }

}

@Composable
fun MyScreenContent(names:List<String> = List(1000){"Hello Android $it"}){
    var counterState:Int by remember{
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxHeight()) {
       NamesList(names = names,modifier = Modifier.weight(1f))

        Counter(
            count=counterState,
            updateCount = { newCount:Int->
                counterState = newCount

            }
        )
        if(counterState>5){
            Text("I Love android")
        }

    }
}

@Composable
fun NamesList(names:List<String>,modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier){
        items(items= names){
            Greeting(name = it)
            Divider()
        }
    }
}


//TOP Level Function
@Composable
fun Greeting(name: String) {
    Surface() {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp(){
        MyScreenContent()
    }

}