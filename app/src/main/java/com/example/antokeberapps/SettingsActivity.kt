package com.example.antokeberapps.pertemuan_9

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    private val menuSettings = listOf(
        "Privacy Policy",
        "About Bina Desa",
        "Pusat Bantuan",
        "Informasi Layanan Desa",
        "Kontak Developer"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            menuSettings
        )

        binding.listSettings.adapter = adapter

        binding.listSettings.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Menu: ${menuSettings[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}