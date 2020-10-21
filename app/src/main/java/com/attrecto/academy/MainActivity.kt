package com.attrecto.academy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast_button.setOnClickListener {
            Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT).show()
        }
    }
}