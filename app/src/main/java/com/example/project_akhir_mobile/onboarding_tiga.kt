package com.example.project_akhir_mobile
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class onboarding_tiga : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_tiga)
    }
    fun login(view: View?) {
        val i = Intent(applicationContext, activity_login::class.java)
        startActivity(i)

    }

}