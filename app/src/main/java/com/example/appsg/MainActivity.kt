package com.example.appsg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appsg.ui.theme.AppSGTheme
import android.util.Log
import androidx.compose.ui.platform.LocalContext

//Plugin FCM
import com.netsend.NetSend
//Plugin FCM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NetSend.initializeNetSend(this, "YOUR_USER_KEY_HERE")
        enableEdgeToEdge()
        setContent {
            AppSGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Button(
        onClick = {
            //val hasPermission = NetSend.hasNotificationPermission(context)
            //val status = if (hasPermission) "✅ CONCEDIDOS" else "❌ DENEGADOS"
            Log.d("MainActivity", "📱 Estado permisos")
        },
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
    ) {
        Text("🔔 Solicitar Permisos Push")
    }
    
    // ✅ BOTÓN 2: Verificar permisos push
    Button(
        onClick = {
            if (context is MainActivity) {
                // val hasPermission = context.hasNotificationPermission()
                // val status = if (hasPermission) "✅ CONCEDIDOS" else "❌ DENEGADOS"
                Log.d("MainActivity", "📱 Estado permisos")
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("🔍 Verificar Permisos Push")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppSGTheme {
        Greeting("Android")
    }
}