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

    // size
    private var ekrangenisligi=0
    private var ekranyuksekligi=0
    private var anakaraktergenisligi=0
    private var anakarakteryuksekligi=0

    // controls
    private var dokunmaControl=false
    private var baslangicControl=false

    private val timer  = Timer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun_ekrani)


        cl.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {

                if(baslangicControl){
                    if(event?.action==MotionEvent.ACTION_DOWN){

                        Log.d("oyunekrani","Down")
                        dokunmaControl=true
                    }
                    if(event?.action==MotionEvent.ACTION_UP){
                        Log.d("oyunekrani","Down")
                        dokunmaControl=false

                    }
                }else{

                    baslangicControl=true
                    anakarakterX=anakarakter.x
                    anakarakterY=anakarakter.y

                    anakaraktergenisligi=anakarakter.width
                    anakarakteryuksekligi=anakarakter.height
                    ekrangenisligi=cl.width
                    ekranyuksekligi=cl.height



                    timer.schedule(0,20){
                        Handler(Looper.getMainLooper()).post{
                            if(dokunmaControl){
                                anakarakterY-=20.0f
                            }else{
                                anakarakterY+=20.0f
                            }

                            if(anakarakterY<= 0.0f){
                                anakarakterY=0.0f
                            }
                            if(anakarakterY >=ekranyuksekligi-anakarakteryuksekligi){
                                anakarakterY=(ekranyuksekligi-anakarakteryuksekligi).toFloat()

                            }


                            anakarakter.y=anakarakterY
                        }
                    }

                }









                return true
            }

        })



    }






}