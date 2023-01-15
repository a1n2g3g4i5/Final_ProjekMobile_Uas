package com.example.project_akhir_mobile.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_akhir_mobile.R
import com.example.project_akhir_mobile.model.Photo
import kotlinx.android.synthetic.main.item_list.view.*


class PhotoListAdapter (var photos: ArrayList<Photo>) :
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>(){
    fun updatePhotos(newPhotos: List<Photo>){
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
    )
    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){

        holder.bind(photos[position])
    }
    class  ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(photos: Photo) {
            val gambar :ImageView =itemView.imageView
            itemView.tvTitle.text = photos.title
            itemView.tvRating.text = photos.rating.toString()
//            Log.e("err",photos.rating)
            itemView.tvLokasi.text = photos.lokasi
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, detail_hotel::class.java)
                intent.putExtra("judul",photos.title)
                intent.putExtra("lokasi",photos.lokasi)
                intent.putExtra("rating",photos.rating)
                intent.putExtra("gambar",photos.thumbnail)
                itemView.context.startActivity(intent)
            }

            val urGambar=photos.thumbnail.toString().filterNot { it.isWhitespace() }

            Glide.with(itemView.context)
                .load("$urGambar")
                .into(gambar)
//            Glide.with(itemView.context).load(photos.thumbnail).into(itemView.imageView)
        }

    }

}
