package com.obaap.firstapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main3.view.*

class Main3Activity : AppCompatActivity() {
    var gallery:Button?=null
    var what:Button?=null
    var hike:Button?=null
    var back:Button?=null
    var call:Button?=null
    var et:EditText?=null
    var handler=Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var i=intent
        gallery=findViewById(R.id.gallery)
        what=findViewById(R.id.whatsapp)
        call=findViewById(R.id.call)
        back=findViewById(R.id.back)
        hike=findViewById(R.id.hike)
        back!!.text=i.getStringExtra("user")
        handler.postDelayed(Runnable {
            gallery!!.visibility=View.VISIBLE
        },2000)
        handler.postDelayed(Runnable {
            what!!.visibility=View.VISIBLE
        },3000)
        handler.postDelayed(Runnable {
            hike!!.visibility=View.VISIBLE
        },4000)
        handler.postDelayed(Runnable {
            back!!.visibility=View.VISIBLE
        },5000)
        handler.postDelayed(Runnable {
            call!!.visibility=View.VISIBLE
        },6000)
    }
    fun click(v:View){
        et=findViewById(R.id.phone)
        if(v.id==R.id.call){
          var i=Intent()

            i.setData(Uri.parse("tel:"+et!!.text.toString()))
            i.setAction(Intent.ACTION_DIAL)
            startActivity(i)
        }else if(v.id==R.id.back){
            finish()
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
        }else if(v.id==R.id.gallery){

        }
    }
}
