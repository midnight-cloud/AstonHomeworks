package com.evg_ivanoff.astonhomeworks

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Ex1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)
        findViewById<View>(R.id.austria).setOnClickListener {
            Toast.makeText(
                this@Ex1Activity,
                "Austria - Австрия",
                Toast.LENGTH_SHORT
            ).show()
        }
        findViewById<View>(R.id.poland).setOnClickListener {
            Toast.makeText(
                this@Ex1Activity,
                "Poland - Польша",
                Toast.LENGTH_SHORT
            ).show()
        }
        findViewById<View>(R.id.italy).setOnClickListener {
            Toast.makeText(
                this@Ex1Activity,
                "Italy - Италия",
                Toast.LENGTH_SHORT
            ).show()
        }
        findViewById<View>(R.id.columbia).setOnClickListener {
            Toast.makeText(
                this@Ex1Activity,
                "Columbia - Колумбия",
                Toast.LENGTH_SHORT
            ).show()
        }
        findViewById<View>(R.id.madagaskar).setOnClickListener {
            Toast.makeText(
                this@Ex1Activity,
                "Madagaskar - Мадагаскар",
                Toast.LENGTH_SHORT
            ).show()
        }
        findViewById<View>(R.id.thailand).setOnClickListener {
            Toast.makeText(
                this@Ex1Activity,
                "Thailand - Таиланд",
                Toast.LENGTH_SHORT
            ).show()
        }
        findViewById<View>(R.id.daniya).setOnClickListener {
            Toast.makeText(
                this@Ex1Activity,
                "Daniya - Дания",
                Toast.LENGTH_SHORT
            ).show()
        }
        findViewById<View>(R.id.switzerland).setOnClickListener {
            Toast.makeText(
                this@Ex1Activity,
                "Switzerland - Швейцария",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}