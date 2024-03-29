package com.example.composestatedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composestatedemo.ui.theme.ComposeStateDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MyViewModel>()
            ComposeStateDemoTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    var count = viewModel.count
                    MyButton(count) {
                       viewModel.increaseCount()
                    }

                }

            }
        }
    }
}

// they are 2 paremeters current value to display and event that request current value to change
@Composable
fun MyButton(currentCount:Int,updateCount:(Int)->Unit){
    Button(onClick = {
        updateCount(currentCount)
    },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White

        )
    ) {
        Text("Count is : $currentCount",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(5.dp))
    }
}