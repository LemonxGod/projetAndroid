package com.example.kamevent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton



class Inscription : AppCompatActivity() ,View.OnClickListener{
    lateinit var returnBouton  : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inscription)
        this.returnBouton = findViewById(R.id.returnButton) as ImageButton
        this.returnBouton.setOnClickListener(this)
    }

    fun returnFunction(view: View) {
        when (view.id) {
            R.id.returnButton -> {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i);
            }
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}

