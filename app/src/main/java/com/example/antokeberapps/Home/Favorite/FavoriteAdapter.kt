package com.example.antokeberapps.Favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.antokeberapps.Data.Entity.FavoriteNewsEntity
import com.example.antokeberapps.databinding.ItemFavoriteBinding

class FavoriteAdapter(
    private val favorites: List<FavoriteNewsEntity>
) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemFavoriteBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFavoriteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = favorites[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.tvDesc.text = item.description
    }

    override fun getItemCount(): Int = favorites.size
}