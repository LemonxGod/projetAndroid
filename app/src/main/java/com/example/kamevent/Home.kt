package com.example.kamevent

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.kamevent.databinding.ActivityHomeBinding
import com.example.kamevent.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        var test:ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(test.root)
        test.textView8.text = "test1"
    }
}