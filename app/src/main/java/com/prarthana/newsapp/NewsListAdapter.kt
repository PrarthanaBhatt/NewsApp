package com.prarthana.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val items: ArrayList<String>,private val listener:NewsItemCicked): RecyclerView.Adapter<NewsViewHolder>() {
    //when we create viewHolder
    //when it will get called?...according to screen how many views can be generated that much time
    //after that it does recycler on it
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        //itemView is xml and view ....so to convert that xml to view we use layout inflater
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder =NewsViewHolder(view)
        view.setOnClickListener{
                listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    //binds data to holder
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem
    }

    //only 1 time called ...how many items are in data that total count
    override fun getItemCount(): Int {
        return items.size
    }


}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView: TextView = itemView.findViewById(R.id.title)
}

interface NewsItemCicked{
    fun onItemClicked(item: String)
}