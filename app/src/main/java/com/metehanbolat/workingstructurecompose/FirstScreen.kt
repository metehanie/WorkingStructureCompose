package com.metehanbolat.workingstructurecompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.metehanbolat.workingstructurecompose.NavigationControllerConstants.FIRST_SCREEN
import com.metehanbolat.workingstructurecompose.NavigationControllerConstants.MAIN_SCREEN
import com.metehanbolat.workingstructurecompose.NavigationControllerConstants.SECOND_SCREEN

@Composable
fun FirstScreen(
    navController: NavController = rememberNavController(),
    document: Triple<String, String, String>,
    person: Person
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Favorite Screen", fontSize = 50.sp)

        Text(text = "Name: ${person.name}\nAge: ${person.age}\nCity: ${person.city}")

        Text(text = document.first)
        Text(text = document.second)
        Text(text = document.third)

        Button(
            onClick = {
                navController.navigate(SECOND_SCREEN) {
                    popUpTo(FIRST_SCREEN) { inclusive = true }
                }
            }
        ) {
            Text(text = "Change Screen")
        }

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text(text = "Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    val document = Triple("John", "24", "Washington DC")
    FirstScreen(
        document = document,
        person = Person("Jessica", 32, "London")
    )
}