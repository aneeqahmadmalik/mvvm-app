package com.aneeque.mvvm_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aneeque.mvvm_app.databinding.PhotosItemBinding
import com.aneeque.mvvm_app.responses.PhotosResponseItem
import com.bumptech.glide.Glide

class PhotosAdapter(val context: Context, val list: List<PhotosResponseItem>?) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    inner class PhotosViewHolder(private val binding: PhotosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PhotosResponseItem?) {
            Glide.with(context).load(item?.url).into(binding.ivPhoto)
            binding.tvPhotoTitle.text = item?.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val itemBinding =
            PhotosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = list?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val item = list?.get(position)
        holder.bind(item)
    }
}