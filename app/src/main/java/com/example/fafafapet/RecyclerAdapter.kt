package com.example.fafafapet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private var titles = arrayOf("Kucing1", "Anjing1", "Kucing2", "Anjing2", "Kucing3", "Anjing3", "Kucing4", "Anjing4")
    private var details = arrayOf("Kucing1", "Anjing1", "Kucing2", "Anjing2", "Kucing3", "Anjing3", "Kucing4", "Anjing4")
    private var images = intArrayOf(R.drawable.kucing1, R.drawable.anjing1, R.drawable.kucing2, R.drawable.anjing2,
        R.drawable.kucing3, R.drawable.anjing3, R.drawable.kucing4, R.drawable.anjing4)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }
    }

}