package com.ddenfi.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWtihDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_wtih_data)

        val tvDataReceived: TextView = findViewById(R.id.data_received_tv)

        val name= intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE,0)

        val text = "Name : $name,Your Age : $age"
        tvDataReceived.text = text
    }
}