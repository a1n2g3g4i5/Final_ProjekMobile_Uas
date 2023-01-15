package com.example.project_akhir_mobile.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.project_akhir_mobile.R
import kotlinx.android.synthetic.main.detail_kuliner.*

class detail_kuliner:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_kuliner)
        ls_judul.text = intent.getStringExtra("judul")
        ls_lokasi.text = intent.getStringExtra("lokasi")
        ls_rating.text = intent.getStringExtra("rating")

        Glide.with(this)
            .load(intent.getStringExtra("gambar"))
            .into(imageView)
    }
}
