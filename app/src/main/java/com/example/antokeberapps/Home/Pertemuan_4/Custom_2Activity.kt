package com.example.antokeberapps.pertemuan_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.databinding.Custom2Binding

class Custom_2Activity : AppCompatActivity() {

    private lateinit var binding: Custom2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Custom2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsi = intent.getStringExtra("EXTRA_DESC")
        val footerTxt = intent.getStringExtra("EXTRA_FOOTER")
        val logoRes = intent.getIntExtra("EXTRA_LOGO", 0)

        binding.tvJudulHeader.text = judul ?: "Default Judul"
        binding.tvDescHeader.text = deskripsi ?: "Default Deskripsi"
        binding.Footer.text = footerTxt ?: "Footer"

        if (logoRes != 0) {
            binding.logoFooter.setImageResource(logoRes)
        }
    }
}