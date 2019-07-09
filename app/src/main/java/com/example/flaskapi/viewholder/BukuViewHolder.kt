package com.example.flaskapi.viewholder

import android.view.View
import android.widget.TextView
import com.example.flaskapi.App
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flaskapi.R
import com.example.flaskapi.model.Buku
import kotlinx.android.synthetic.main.item_buku.view.*

class BukuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvJudul: TextView = itemView!!.findViewById(R.id.title)
    /*
    fun bind(buku: Buku) {
/*
        Glide.with(App.context!!)
            .load(buku.judul)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(itemView.ivImage)
*/
        //
        //itemView.tvJudul.text = buku.judul
    }
    */
}
