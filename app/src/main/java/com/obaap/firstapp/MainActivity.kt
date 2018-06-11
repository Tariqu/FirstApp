package com.obaap.firstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.view.View;
import android.os.Handler;
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var rellay1: RelativeLayout? = null
    var rellay2: RelativeLayout? = null
    val b1:Button?=null
    var handler = Handler()
    var runnable: Runnable = Runnable {
        rellay1!!.visibility = View.VISIBLE
        rellay2!!.setVisibility(View.VISIBLE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rellay1 =  findViewById(R.id.rellay1)
        rellay2 =  findViewById(R.id.rellay2)
        handler.postDelayed(runnable, 2000)
        val b1 = findViewById(R.id.b1) as Button
        b1.setOnClickListener {
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            val intent= Intent(this@MainActivity,Main3Activity::class.java)
            intent.putExtra("user",et1.text.toString())
            startActivity(intent)
        }
    }

}
