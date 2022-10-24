package com.salim.bitaqwa.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.salim.bitaqwa.R
import com.salim.bitaqwa.dashboard.model.InspirationModel

class InpirationListAdapter(
    private val listInpiration : ArrayList<InspirationModel>
) : RecyclerView.Adapter<InpirationListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto : ImageView = itemView.findViewById(R.id.item_inspiration)
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int
    ): InpirationListAdapter.ListViewHolder {
       val view : View = LayoutInflater.from(parent.context)
           .inflate(R.layout.item_row_inspirations, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: InpirationListAdapter.ListViewHolder, position: Int) {
        val inspiration = listInpiration[position]
        Glide.with(holder.itemView.context)
            .load(inspiration.inspirationImage)
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return listInpiration.size
    }

}