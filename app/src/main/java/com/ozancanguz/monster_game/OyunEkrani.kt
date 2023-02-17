package com.ozancanguz.monster_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_oyun_ekrani.*
import java.util.*
import kotlin.concurrent.schedule

class OyunEkrani : AppCompatActivity() {

    // positions
    private var anakarakterX=0.0f
    private var anakarakterY=0.0f

    // controls
    private var dokunmaControl=true

    private val timer  = Timer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun_ekrani)


        cl.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {



                if(event?.action==MotionEvent.ACTION_DOWN){

                    Log.d("oyunekrani","Down")
                }
                if(event?.action==MotionEvent.ACTION_UP){
                    Log.d("oyunekrani","Down")

                }

                anakarakterX=anakarakter.x
                anakarakterY=anakarakter.y


                timer.schedule(0,20){
                    Handler(Looper.getMainLooper()).post{
                        if(dokunmaControl){
                            anakarakterY-=20.0f
                        }else{
                            anakarakterY+=20.0f

                        }
                        anakarakter.y=anakarakterY
                    }
                }



                return true
            }

        })



    }






}