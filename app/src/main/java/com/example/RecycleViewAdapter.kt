package com.example

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        val tvDesc = view.tv_description
        val imgThumb = view.imgThumb
        fun bind(data: RecyclerData){
            tvTitle.text = data.name;
            if(TextUtils.isEmpty(data.description)){
                tvDesc.text = "No Description Availble"
            } else {
                tvDesc.text = data.description
            }

            val url = data.owner.avatar_url;
            Glide.with(imgThumb).load(url).circleCrop().placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_background).fallback(R.drawable.ic_launcher_background).into(imgThumb)
        }

    }
}