package com.example.project_akhir_mobile



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.project_akhir_mobile.view.MainActivity
import com.example.project_akhir_mobile.view.MainKuliner
import com.example.project_akhir_mobile.view.MainWisata
import kotlinx.android.synthetic.main.detail_kuliner.*
import kotlinx.android.synthetic.main.fragment_home.*

class home : AppCompatActivity() {
    private var linearLayout: LinearLayout?=null
    private val menu = arrayOf("Hotel Bono","Hotel Pangeran","Hotel Merdeka")
    private val gambar = intArrayOf(R.drawable.ht1,R.drawable.ht2,R.drawable.ht1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)


        linearLayout = findViewById(R.id.linear1)
        val layoutInflater = LayoutInflater.from(this)

        for (i in menu.indices) {
            val view: View = layoutInflater.inflate(R.layout.layout_utama, linearLayout, false)
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(gambar[i])
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.text = menu[i]
            linearLayout?.addView(view)

        }
    }

    fun profil(view: View?) {
        val i = Intent(applicationContext, profil::class.java)
        startActivity(i)

    }
    fun hotel(view: View?) {
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)

    }
    fun wisata(view: View?) {
        val i = Intent(applicationContext, MainWisata::class.java)
        startActivity(i)

    }
    fun kuliner(view: View?) {
        val i = Intent(applicationContext, MainKuliner::class.java)
        startActivity(i)

    }
    fun maps(view: View?) {
        val i = Intent(applicationContext, Maps::class.java)
        startActivity(i)

    }


}