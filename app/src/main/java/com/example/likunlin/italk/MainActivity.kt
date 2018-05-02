package com.example.likunlin.italk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.likunlin.italk.talk.talk
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val btn_talk_click = View.OnClickListener{
        val intent2 = Intent(this,talk::class.java)
        startActivity(intent2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_talk.setOnClickListener(btn_talk_click)
    }
}
