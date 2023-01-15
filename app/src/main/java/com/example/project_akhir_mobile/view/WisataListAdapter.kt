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
import kotlinx.android.synthetic.main.item_wisata.view.imageView
import kotlinx.android.synthetic.main.item_wisata.view.*

class WisataListAdapter(var photos: ArrayList<Photo>) :
   RecyclerView.Adapter<WisataListAdapter.ViewHolder>(){
    fun updatePhotos(newPhotos: List<Photo>){
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_wisata,parent,false)
    )
    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){

        holder.bind(photos[position])
    }
    class  ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(photos: Photo) {
            val gambar : ImageView =itemView.imageView
            itemView.ls_wisata.text = photos.titleWisata
            itemView.ls_rating.text = photos.ratingWisata.toString()
//            Log.e("err",photos.rating)
            itemView.ls_lokasi.text = photos.lokasiWisata
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, detail_wisata::class.java)
                intent.putExtra("judul",photos.titleWisata)
                intent.putExtra("lokasi",photos.lokasiWisata)
                intent.putExtra("rating",photos.ratingWisata)
                intent.putExtra("gambar",photos.gambarWisata)
                itemView.context.startActivity(intent)
            }
            val urGambar=photos.gambarWisata.toString().filterNot { it.isWhitespace() }

            Glide.with(itemView.context)
                .load("$urGambar")
                .into(gambar)
//            Glide.with(itemView.context).load(photos.thumbnail).into(itemView.imageView)
        }
    }
}