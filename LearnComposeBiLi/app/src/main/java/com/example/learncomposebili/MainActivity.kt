package com.example.learncomposebili

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncomposebili.ui.theme.LearnComposeBiLiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeBiLiTheme {
                // A surface container using the 'background' color from the theme
                Myapp()
            }
        }
    }
}

@Composable
fun Myapp() {
    var shouldShowOnbroading by remember {
        mutableStateOf(true)
    }
    if (shouldShowOnbroading) {
        OnBoardingScreen(onContinueClick = {shouldShowOnbroading = false})
    } else {
        Greeting()
    }
}

@Composable
fun Greeting(names: List<String> = listOf("lili","dada")) {
    androidx.compose.material.Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            for (name in names) {
                Greetingitem(name)
            }
        }
    }
}

@Composable
fun Greetingitem(name: String) {
    androidx.compose.material.Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(8.dp, vertical = 4.dp)
    ) {
        val expanded = remember{mutableStateOf(false)}
        var expandedPadding = if (expanded.value) 48.dp else 0.dp

        Row( modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = expandedPadding)
            ) {
                Text(text = "Hello,")
                Text(text = "$name!")
            }

            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (!expanded.value) "show more" else "show less")
            }
        }
    }
}

@Composable
fun OnBoardingScreen(
    onContinueClick: () -> Unit
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "welcome to code laber!")
            Button(
                modifier = Modifier.padding(24.dp),
                onClick = onContinueClick
            ) {
                Text(text = "Continue")
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview() {
    LearnComposeBiLiTheme {
        OnBoardingScreen(onContinueClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnComposeBiLiTheme {
        Greeting()
    }
}