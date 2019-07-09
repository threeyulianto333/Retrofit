package com.example.flaskapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flaskapi.R
import com.example.flaskapi.model.Buku
import com.example.flaskapi.viewholder.BukuViewHolder

class BukuAdapter(val context: Context) : RecyclerView.Adapter<BukuViewHolder>() {

    var bukuList : List<Buku> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buku, parent, false)
        return BukuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bukuList.size
    }

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        //holder.bind(data[position])

        holder.tvJudul.text = bukuList.get(position).judul
        /*
        Glide.with(context).load(bukuList.get(position).image)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
            */
    }

    fun setBukuListItems(bukuList: List<Buku>){
        this.bukuList = bukuList
        notifyDataSetChanged()
    }
}