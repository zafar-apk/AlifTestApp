package zafar.abdulloev.aliftest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import zafar.abdulloev.aliftest.ui.theme.AlifTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlifTestAppTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}