package com.example.antokeberapps.Home.Berita

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.antokeberapps.Data.Model.BeritaModel
import com.example.antokeberapps.databinding.ItemBeritaBinding

class BeritaAdapter(
    private val beritaList: List<BeritaModel>
) : RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ItemBeritaBinding
    ) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemBeritaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val berita = beritaList[position]

        holder.binding.tvTitle.text = berita.title
        holder.binding.tvBody.text = berita.body
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }
}