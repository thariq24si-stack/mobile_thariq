package com.example.antokeberapps.pertemuan_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// Pastikan nama binding-nya sesuai dengan nama XML-mu (activity_third_result -> ActivityThirdResultBinding)
import com.example.antokeberapps.databinding.ActivityThirdResultBinding
import com.example.antokeberapps.pertemuan_4.DashboardActivity

import kotlin.jvm.java

class ThirdResultActivity : AppCompatActivity() {

    // 1. Deklarasi binding
    private lateinit var binding: ActivityThirdResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inisialisasi binding
        binding = ActivityThirdResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 3. Logika pindah ke Dashboard pakai ID tombol dari XML
        // Misal di XML ID tombol loginnya adalah button2
        binding.button2.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)

            // Tutup halaman login biar gak bisa di-back
            finish()
        }
    }
}