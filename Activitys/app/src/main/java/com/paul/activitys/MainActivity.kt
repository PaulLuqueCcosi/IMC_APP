package com.paul.activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    val TAG : String = "mainActivity";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "On create");

        setContentView(R.layout.main_activity)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val etName = findViewById<EditText>(R.id.etName)

        btnStart.setOnClickListener{
            val name = etName.text.toString()
            Log.d(TAG, "Hola ${name}")
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, etName.text.toString(), duration) // in Activity
            toast.show()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("TEXT_NAME", name)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "on resume")
    }


    override fun onPause() {
        super.onPause()
        Log.d(TAG, "on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "on restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "on destroy")
    }

}

