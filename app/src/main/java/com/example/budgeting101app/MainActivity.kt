package com.example.budgeting101app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.budgeting101app.ui.theme.Budgeting101AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Budgeting101AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize().background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(146, 188, 129),
                                Color(220, 236, 213)
                            )
                ))){
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val mContext = LocalContext.current
    Column (verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.width(IntrinsicSize.Max).background(
        brush = Brush.verticalGradient(
            colors = listOf(
                Color(146, 188, 129),
                Color(220, 236, 213)
            )
        ))){
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)){
            Text(
                text = "Budgeting",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 25.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
            Text(
                text = "101",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 35.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = R.drawable.b101_money),
                contentDescription = "Home screen money",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Column (modifier = Modifier.align(Alignment.CenterHorizontally)){
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter Name:") }
            )
            Button(onClick = {
                val intent = Intent(mContext, Learn::class.java);
                intent.putExtra("name", text);
                mContext.startActivity(intent);  }, modifier = Modifier.align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(containerColor = Color(146, 188, 129), contentColor = Color(0, 0, 0))
            ) {
                Text("Start")
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Budgeting101AppTheme {
        Greeting("Android")
    }
}