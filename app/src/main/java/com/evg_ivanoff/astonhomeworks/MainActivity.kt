package com.evg_ivanoff.astonhomeworks

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var btnEx1: Button
    private lateinit var btnEx2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEx1 = findViewById(R.id.btnExercise1)
        btnEx2 = findViewById(R.id.btnExercise2)
        btnEx1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Ex1Activity::class.java)
            startActivity(intent)
        })
        btnEx2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Ex2Activity::class.java)
            startActivity(intent)
        })
    }
}