package com.example.antokeberapps.Home.Berita

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.antokeberapps.Data.AppDatabase
import com.example.antokeberapps.Data.Entity.FavoriteNewsEntity
import com.example.antokeberapps.Data.Model.BeritaModel
import com.example.antokeberapps.databinding.ItemBeritaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

        // TAMBAHAN ROOM FAVORITE (tidak mengubah code lama)
        holder.binding.btnSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                val db = AppDatabase.getInstance(
                    holder.itemView.context
                )

                db.favoriteNewsDao().insert(
                    FavoriteNewsEntity(
                        title = berita.title,
                        description = berita.body
                    )
                )

                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(
                        holder.itemView.context,
                        "Berita disimpan ke Favorite",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }
}