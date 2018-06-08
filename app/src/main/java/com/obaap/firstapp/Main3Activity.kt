package com.obaap.firstapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main3.view.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }
    fun click(v:View){
        var et:EditText=findViewById(R.id.phone)
        if(v.id==R.id.call){
          var i=Intent()

            i.setData(Uri.parse("tel:"+et.text.toString()))
            i.setAction(Intent.ACTION_DIAL)
            startActivity(i)
        }else if(v.id==R.id.back){
            var i=Intent(this,MainActivity::class.java)
            startActivity(i)
        }else if(v.id==R.id.hike){
            var i=packageManager.getLaunchIntentForPackage("com.bsb.hike")
            if(i!=null) {
                startActivity(i)
            }else{
                i=Intent()
                i.setData(Uri.parse("market://details?id=com.bsb.hike"))
                i.setAction(Intent.ACTION_VIEW)
                startActivity(i)
            }

        }else if(v.id==R.id.whatsapp){
            var i=packageManager.getLaunchIntentForPackage("com.whatsapp")
            if(i!=null) {
                startActivity(i)
            }else{
                i=Intent()
                i.setData(Uri.parse("market://details?id=com.whatsapp"))
                i.setAction(Intent.ACTION_VIEW)
                startActivity(i)
            }
        }
    }
}
