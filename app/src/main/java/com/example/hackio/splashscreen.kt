package com.example.hackio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class splashscreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}