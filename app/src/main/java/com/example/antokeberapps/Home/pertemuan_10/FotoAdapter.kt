package com.example.antokeberapps.DataFoto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.antokeberapps.databinding.ItemFotoBinding

class FotoAdapter(
    private val listFoto: List<FotoModel>
) : RecyclerView.Adapter<FotoAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ItemFotoBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding = ItemFotoBinding.inflate(
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

        val data = listFoto[position]

        holder.binding.tvTitle.text =
            data.title

        holder.binding.tvDesc.text =
            data.description

        holder.binding.imgFoto.setImageResource(
            data.image
        )
    }

    override fun getItemCount(): Int {

        return listFoto.size
    }
}