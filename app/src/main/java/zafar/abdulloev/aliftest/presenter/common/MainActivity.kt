package zafar.abdulloev.aliftest.presenter.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import zafar.abdulloev.aliftest.presenter.common.theme.AlifTestAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        setContent {
            AlifTestAppTheme {
                Surface(color = MaterialTheme.colors.background) {

                    AppContent()

                }
            }
        }
    }
}