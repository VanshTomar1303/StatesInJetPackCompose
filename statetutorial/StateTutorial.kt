package com.vansh.statetutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

// remember -> it persist state on recomposition
// rememberSaveable -> it persist even the configuration changes
// in simple word they store data like memory

// view model and live data -> Host the state re-usability

@Composable
fun StateTutorial(viewModelTutorial: StateViewModelTutorial){
//    var name by remember {
//        mutableStateOf("")
//    }
//    var name by rememberSaveable {
//        mutableStateOf("")
//    }
    val name by viewModelTutorial.name.observeAsState(initial = "")
    //val surName by viewModelTutorial.surName.observeAsState(initial = "")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Txt(name)
        TextField(name,onChangeName = {
            //name = it
            viewModelTutorial.onNameUpdate(it)
        })
    }
}

@Composable
fun Txt(name: String){
    Text(
        text = "Hello $name",
        fontFamily = FontFamily.Monospace,
        fontSize = 20.sp
    )
}

@Composable
fun TextField(name: String,onChangeName: (String) -> Unit){
    OutlinedTextField(
        value = name,
        onValueChange = {
            onChangeName(it)
        },
        label = {
            Text(text = "Enter name")
        }
        )
}