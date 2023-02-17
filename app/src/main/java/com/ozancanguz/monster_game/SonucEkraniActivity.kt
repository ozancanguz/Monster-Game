package com.ozancanguz.monster_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sonuc_ekrani.*

class SonucEkraniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_ekrani)

        tekrardenebtn.setOnClickListener {
            startActivity(Intent(this@SonucEkraniActivity,MainActivity::class.java))

        }

    }
}