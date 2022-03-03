package com.example.kamevent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kamevent.auth.Authenticate
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var buttonInscription : Button
    lateinit var buttonConnexion  : Button

    companion object{
        var auth : Authenticate =  Authenticate()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "Creating Main Activity...")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.buttonInscription = findViewById(R.id.button2) as Button
        this.buttonInscription.setOnClickListener(this)
        this.buttonConnexion = findViewById(R.id.button) as Button
        this.buttonConnexion.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            /* R.id.buttonConnexion -> {
                 val i = Intent(this@MainActivity, FilActualite::class.java)
                 startActivity(i)
             }*/
            R.id.button2 -> {
                val i = Intent(this, Inscription::class.java)
                startActivity(i)
            }
        }
    }
    public fun onClickHome (v: View){
        setContentView(R.layout.activity_home)
    }
}

annotation class override
