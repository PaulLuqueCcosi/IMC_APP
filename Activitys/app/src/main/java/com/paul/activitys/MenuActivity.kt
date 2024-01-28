package com.paul.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paul.activitys.IMCapp.IMC_activity
import com.paul.activitys.firstApp.MainActivity
import com.paul.activitys.ui.theme.ActivitysTheme

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)

        val btnSaludar = findViewById<Button>(R.id.btnSaludarApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnSaludar.setOnClickListener { goToSaludarapp() }
        btnIMCApp.setOnClickListener { goToIMCapp() }


    }


    private fun goToSaludarapp() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun goToIMCapp() {
        val intent = Intent(this, IMC_activity::class.java)
        startActivity(intent)
    }
}