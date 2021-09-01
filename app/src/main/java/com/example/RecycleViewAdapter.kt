package com.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycleview_row.view.*

class RecycleViewAdapter: RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>() {
    var items = ArrayList<RecyclerData>()

    fun setListData(data : ArrayList<RecyclerData>){
        this.items = data;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewAdapter.MyViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_row, parent, false)

        return MyViewHolder(inflate);
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position]);
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvTitle = view.tv_title;
        fun bind(title: RecyclerData){
            tvTitle.text = title.title;

        }

    }
}