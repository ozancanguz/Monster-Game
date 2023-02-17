package com.ozancanguz.monster_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_oyun_ekrani.*

class OyunEkrani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun_ekrani)

        anakarakter.setOnClickListener {
            startActivity(Intent(this@OyunEkrani,SonucEkraniActivity::class.java))

            finish()
        }

        cl.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {



                if(event?.action==MotionEvent.ACTION_DOWN){

                    Log.d("oyunekrani","Down")
                }
                if(event?.action==MotionEvent.ACTION_UP){
                    Log.d("oyunekrani","Down")

                }
                return true
            }

        })



    }
}