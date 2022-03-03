package com.example.kamevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.kamevent.schemas.Likes
import com.example.kamevent.schemas.Post
import java.util.*


class Posts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
    }
}
/*class Posts : AppCompatActivity(), View.OnClickListener{
    var post =  Post("ramos",
        "Test 1",
        Calendar.getInstance().time,
        "Un simple test",
        null,
        null,
        Likes(listOf("5")))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        Log.d("testText", "Create")
    }

    override fun onClick(p0: View?) {
        var testText = findViewById<TextView>(R.id.testText)
        testText.setText("Test 2")
        Log.d("testText", "Fonctionne")
    }
}*/