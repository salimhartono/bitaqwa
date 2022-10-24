package com.salim.bitaqwa.menus.doa.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.salim.bitaqwa.R
import com.salim.bitaqwa.menus.doa.DetailDoaActivity
import com.salim.bitaqwa.menus.doa.model.DoaModel

class DoaListAdapter(
    private var listDoa: ArrayList<DoaModel>,
    private var title: String,
    private var logo: Int
) : RecyclerView.Adapter<DoaListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var ivLogoDoa : ImageView = itemView.findViewById(R.id.iv_logo_doa)
        var tvTitleDoa : TextView = itemView.findViewById(R.id.tv_title_doa)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoaListAdapter.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_doa, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoaListAdapter.ListViewHolder, position: Int) {
        val doa = listDoa[position]
        holder.tvTitleDoa.text = doa.title
        Glide.with(holder.itemView.context)
            .load(logo)
            .into(holder.ivLogoDoa)

        //tambahkan clik
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailDoaActivity::class.java)
            intent.putExtra(DetailDoaActivity.EXTRA_DOA, doa)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listDoa.size
    }
}