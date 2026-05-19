package com.example.antokeberapps.pertemuan_9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.databinding.ActivityPertemuan9Binding
import com.google.android.material.snackbar.Snackbar

class Pertemuan9Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPertemuan9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPertemuan9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnKirim.setOnClickListener {

            val nama = binding.etNama.text.toString()
            val aspirasi = binding.etAspirasi.text.toString()

            if (nama.isEmpty() || aspirasi.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Semua field harus diisi",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                Snackbar.make(
                    binding.root,
                    "Aspirasi berhasil dikirim",
                    Snackbar.LENGTH_LONG
                ).show()

                binding.etNama.text?.clear()
                binding.etAspirasi.text?.clear()
            }
        }
    }
}