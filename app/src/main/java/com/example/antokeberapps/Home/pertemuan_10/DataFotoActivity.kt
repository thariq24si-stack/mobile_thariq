package com.example.antokeberapps.DataFoto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.antokeberapps.R
import com.example.antokeberapps.databinding.ActivityDataFotoBinding

class DataFotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataFotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityDataFotoBinding.inflate(
            layoutInflater
        )

        setContentView(binding.root)

        val listFoto = listOf(

            FotoModel(
                "Gunung",
                "Pemandangan pegunungan",
                R.drawable.founder
            ),

            FotoModel(
                "Pantai",
                "Pantai laut biru",
                R.drawable.founder
            ),

            FotoModel(
                "Sawah",
                "Area persawahan hijau",
                R.drawable.founder
            ),

            FotoModel(
                "Desa",
                "Suasana desa wisata",
                R.drawable.founder
            )

        )

        val adapter = FotoAdapter(
            listFoto
        )

        binding.recyclerView.layoutManager =
            GridLayoutManager(
                this,
                2
            )

        binding.recyclerView.adapter =
            adapter
    }
}