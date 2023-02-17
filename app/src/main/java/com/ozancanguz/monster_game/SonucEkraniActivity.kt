package com.ozancanguz.monster_game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_oyun_ekrani.*
import kotlinx.android.synthetic.main.activity_sonuc_ekrani.*

class SonucEkraniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_ekrani)

        // sonuc skor

        val skor =intent.getIntExtra("skor",0)
        sonucskor.text=skor.toString()

        val sp=getSharedPreferences("Sonuc", Context.MODE_PRIVATE)
        val enyuksekskor=sp.getInt("enyuksekskor",0)

        if(skor>enyuksekskor){

            val editor=sp.edit()
            editor.putInt("enyuksekskor",skor)
            editor.commit()
            enyuksekskortv.text=skor.toString()
        }else{

            enyuksekskortv.text=enyuksekskor.toString()
        }


        tekrardenebtn.setOnClickListener {
            startActivity(Intent(this@SonucEkraniActivity,MainActivity::class.java))

        }



    }
}