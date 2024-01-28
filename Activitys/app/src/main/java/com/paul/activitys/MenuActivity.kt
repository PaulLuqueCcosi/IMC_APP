package com.paul.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.paul.activitys.IMCapp.IMCActivity
import com.paul.activitys.firstApp.MainActivity

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
        val intent1 = Intent(this, IMCActivity::class.java)
        startActivity(intent1)
    }
}