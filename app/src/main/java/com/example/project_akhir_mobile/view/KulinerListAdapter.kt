package com.example.project_akhir_mobile.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_akhir_mobile.R
import com.example.project_akhir_mobile.model.Photo
import kotlinx.android.synthetic.main.item_kuliner.view.*
import java.util.ArrayList

class KulinerListAdapter(var photos:ArrayList<Photo>):
    RecyclerView.Adapter<KulinerListAdapter.ViewHolder>(){
    fun updatePhotos(newPhotos: List<Photo>){
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_kuliner,parent,false)
    )
    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){

        holder.bind(photos[position])
    }
    class  ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(photos: Photo) {
            val gambar : ImageView =itemView.imageView
            itemView.l_judul.text = photos.titleKuliner
            itemView.l_rating.text = photos.ratingKuliner.toString()
//            Log.e("err",photos.rating)
            itemView.l_lokasi.text = photos.lokasiKuliner
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, detail_kuliner::class.java)
                intent.putExtra("judul",photos.titleKuliner)
                intent.putExtra("lokasi",photos.lokasiKuliner)
                intent.putExtra("rating",photos.ratingKuliner)
                intent.putExtra("gambar",photos.gambarKuliner)
                itemView.context.startActivity(intent)
            }
            val urGambar=photos.gambarKuliner.toString().filterNot { it.isWhitespace() }

            Glide.with(itemView.context)
                .load("$urGambar")
                .into(gambar)
//            Glide.with(itemView.context).load(photos.thumbnail).into(itemView.imageView)
        }

    }

}
