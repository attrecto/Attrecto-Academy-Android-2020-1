package com.attrecto.academy.screen.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.attrecto.academy.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        private val ID = "ID"

        fun createLaunchIntent(context : Context, id :String) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(ID, id)
            }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        text_view.text = intent.extras?.getString(ID) ?: "EMPTY"
    }
}