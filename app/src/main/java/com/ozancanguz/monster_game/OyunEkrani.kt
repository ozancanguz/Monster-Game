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
import java.lang.Math.floor
import java.util.*
import kotlin.concurrent.schedule

class OyunEkrani : AppCompatActivity() {

    // positions
    private var anakarakterX=0.0f
    private var anakarakterY=0.0f
    private var siyahkareX=0.0f
    private var siyahkareY=0.0f
    private var morcisimX=0.0f
    private var morcisimY=0.0f
    private var saricisimX=0.0f
    private var saricisimY=0.0f



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


        // cisimlerin yeri
        cisimlerinYeri()



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
                           anakarakterhareket()
                            cisimleriHareketEttirme()
                        }
                    }

                }

                return true
            }

        })



    }




    fun anakarakterhareket(){
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

    fun cisimleriHareketEttirme(){

        siyahkareX-=20.0f
        saricisimX-=15.0f
        morcisimX-=30.0f





        if(siyahkareX<0.0f){
          siyahkareX=  ekrangenisligi+22.0f

            siyahkareY=floor(Math.random()*ekranyuksekligi).toFloat()
        }
      siyahcisim.x=siyahkareX
        siyahcisim.y=siyahkareY



        if(saricisimX<0.0f){
            saricisimX=  ekrangenisligi+22.0f

            saricisimY=floor(Math.random()*ekranyuksekligi).toFloat()
        }
        saricisim.x=saricisimX
        saricisim.y=saricisimY





        if(morcisimX<0.0f){
            morcisimX=  ekrangenisligi+22.0f

            morcisimY=floor(Math.random()*ekranyuksekligi).toFloat()
        }
        morcisim.x=morcisimX
        morcisim.y=morcisimY


    }




    private fun cisimlerinYeri() {
          siyahcisim.x=-800.0f
          siyahcisim.y=-800.0f
          saricisim.x=-800.0f
          saricisim.y=-800.0f
          morcisim.x=-800.0f
          morcisim.y=-800.0f



    }




}