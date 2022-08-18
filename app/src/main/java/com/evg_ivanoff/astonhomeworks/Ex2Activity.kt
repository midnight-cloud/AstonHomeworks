package com.evg_ivanoff.astonhomeworks

import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso


class Ex2Activity : AppCompatActivity() {
    private lateinit var etImageURL: EditText
    private lateinit var image: ImageView
    private val isLoaded = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)
        etImageURL = findViewById(R.id.et_image_url)
        image = findViewById(R.id.imageView)
        etImageURL.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                image.setImageResource(R.drawable.ic_baseline_add)
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        image.setOnClickListener(View.OnClickListener {
            val uri = Uri.parse(etImageURL.text.toString())
            Picasso.get()
                .load(uri)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .placeholder(R.drawable.ic_baseline_load)
                .error(R.drawable.ic_baseline_error)
                .into(image, object : Callback {
                    override fun onSuccess() {}

                    override fun onError(e: Exception?) {
                        Toast.makeText(this@Ex2Activity, "URL error", Toast.LENGTH_SHORT).show()
                    }
                })
        })
    }
}