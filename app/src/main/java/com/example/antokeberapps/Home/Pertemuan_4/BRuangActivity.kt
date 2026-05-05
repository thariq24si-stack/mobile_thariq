package com.example.antokeberapps.pertemuan_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.databinding.BangunRuangBinding
import kotlin.math.pow

class BRuangActivity : AppCompatActivity() {

    private lateinit var binding: BangunRuangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BangunRuangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Logika Hitung Limas: 1/3 * (sisi*sisi) * tinggi
        binding.btnHitungLimas.setOnClickListener {
            val sisi = binding.etSisiAlas.text.toString().toDoubleOrNull() ?: 0.0
            val tinggi = binding.etTinggiLimas.text.toString().toDoubleOrNull() ?: 0.0
            val volume = (1.0/3.0) * (sisi * sisi) * tinggi
            binding.tvHasilLimas.text = "Hasil: %.2f".format(volume)
        }

        // Logika Hitung Bola: 4/3 * PI * r^3
        binding.btnHitungBola.setOnClickListener {
            val r = binding.etJariBola.text.toString().toDoubleOrNull() ?: 0.0
            val volume = (4.0/3.0) * Math.PI * r.pow(3)
            binding.tvHasilBola.text = "Hasil: %.2f".format(volume)
        }

        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsi = intent.getStringExtra("EXTRA_DESC")

        val footerText = intent.getStringExtra("EXTRA_FOOTER")
        val logoRes = intent.getIntExtra("EXTRA_LOGO", 0)

        binding.Footer.text = footerText
        binding.logoFooter.setImageResource(logoRes)
    }
}