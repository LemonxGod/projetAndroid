package com.example.kamevent

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kamevent.auth.SignInConnection

class MainActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var buttonInscription : Button
    lateinit var buttonConnexion  : Button
    var connection : SignInConnection =  SignInConnection()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "Creating Main Activity...")
        connection.signInWithPassword("a@a.fr", "aaaaaa");
        connection.signInWithPassword("a@a.f", "aaaaaa");
        connection.signInWithPassword("a@a.fr", "aaaaa");
        connection.signInWithPassword("v@a.fr", "aaaa");
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
                startActivity(i);
            }
        }
    }
}

annotation class override
