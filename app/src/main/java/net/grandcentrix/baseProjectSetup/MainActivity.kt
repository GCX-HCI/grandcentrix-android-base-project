package net.grandcentrix.baseProjectSetup

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.grandcentrix.core.design.theme.AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                AndroidApp()
            }
        }
    }
}

@Composable
fun AndroidApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) {
        Text("Hello grandcentrix", modifier = Modifier.padding(it))
    }
}

@androidx.compose.ui.tooling.preview.Preview
@Composable
private fun AndroidAppPreview() {
    AppTheme {
        AndroidApp()
    }
}
