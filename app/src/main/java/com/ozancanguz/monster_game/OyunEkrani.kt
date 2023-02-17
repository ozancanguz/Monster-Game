package com.ozancanguz.monster_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_oyun_ekrani.*

class OyunEkrani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun_ekrani)

        anakarakter.setOnClickListener {
            startActivity(Intent(this@OyunEkrani,SonucEkraniActivity::class.java))

            finish()
        }



    }
}