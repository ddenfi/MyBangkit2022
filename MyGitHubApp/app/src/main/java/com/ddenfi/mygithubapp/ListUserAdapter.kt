package com.ddenfi.mygithubapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListUserAdapter(private val listUser:ArrayList<DataUser>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder> (){

    private lateinit var onItemClickCallback: OnItemCLickCallBack

    fun setOnItemClickCallBack(onItemClickCallback: OnItemCLickCallBack){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name, photo) = listUser[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .circleCrop()
            .into(holder.imgPhoto)
        holder.tvUsername.text = username
        holder.tvName.text = name
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    }

    interface OnItemCLickCallBack {
        fun onItemClicked(data: DataUser)
    }

}