package com.example.lottery_app_version_one

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lottery_app_version_one.ui.theme.LotteryappversiononeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LotteryappversiononeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        var result by remember { mutableStateOf(generateLottery()) }

                        Text("${result.get(0)} - ${result.get(1)} - ${result.get(2)} - ${result.get(3)} - ${result.get(4)} - ${result.get(5)}")

                        Button(onClick = {
                            result = generateLottery()
                            Log.i("dev test", "$result")
                        }) {
                            Text("Tap Here")
                        }
                    }
                }
            }
        }
    }
}

fun generateLottery(): List<Int> {
    val numbers = mutableListOf<Int>()

    while (numbers.size < 6) {
        val random = Random.nextInt(59) + 1
        if (random !in numbers) {
            numbers.add(random)
        }
    }

    return numbers
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LotteryappversiononeTheme {
        Greeting("Android")
    }
}