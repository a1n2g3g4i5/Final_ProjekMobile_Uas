package com.example.project_akhir_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class onboarding_satu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_satu)
    }
    fun next(view: View?) {
        val i = Intent(applicationContext, onboarding_dua::class.java)
        startActivity(i)

    }
    fun skip(view: View?) {
        val i = Intent(applicationContext, activity_login::class.java)
        startActivity(i)
    }

}