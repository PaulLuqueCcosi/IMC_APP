package com.paul.activitys.firstApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.paul.activitys.R


class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)
        val vtName = findViewById<TextView>(R.id.tvName)

        val name = intent.extras?.getString("TEXT_NAME").orEmpty()
        vtName.text = "Hola ${name}"

    }
}
