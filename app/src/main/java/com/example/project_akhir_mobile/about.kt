package com.example.project_akhir_mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.project_akhir_mobile.view.MainWisata

class about:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
    }
    fun more(view: View?) {
        val i = Intent(applicationContext, MainWisata::class.java)
        startActivity(i)

    }
}