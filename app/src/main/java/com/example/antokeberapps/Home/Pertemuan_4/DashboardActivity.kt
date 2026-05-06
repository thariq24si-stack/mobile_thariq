package com.example.antokeberapps.pertemuan_4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.example.antokeberapps.Home.pertemuan_3.ThirdResultActivity
import com.example.antokeberapps.R
import com.example.antokeberapps.databinding.DashboardBinding
import com.example.antokeberapps.pertemuan_3.ThrdActivity
import com.example.antokeberapps.pertemuan_4.BRuangActivity
import com.example.antokeberapps.pertemuan_4.Custom_1Activity
import com.example.antokeberapps.pertemuan_4.Custom_2Activity
import com.example.antokeberapps.Pertemuan_6.WebViewActivity
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: DashboardBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        supportActionBar?.title = "Dashboard"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnLogout.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Logout")
            builder.setMessage("Apakah Anda yakin ingin keluar?")

            builder.setPositiveButton("Iya") { dialog, _ ->

                val editor = sharedPref.edit()
                editor.clear()
                editor.apply()

                val intent = Intent(this, ThirdResultActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

                dialog.dismiss()
            }

            builder.setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
                Snackbar.make(
                    binding.root,
                    "Logout dibatalkan",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            builder.show()
        }


        binding.btnWeb.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }


        binding.btnBangunRuang.setOnClickListener {
            val intent = Intent(this, BRuangActivity::class.java)

            intent.putExtra("EXTRA_FOOTER", "AppleApps")
            intent.putExtra("EXTRA_LOGO", R.drawable.apple)

            startActivity(intent)
        }

        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, Custom_1Activity::class.java)

            intent.putExtra("EXTRA_JUDUL", "Halaman Informasi")
            intent.putExtra("EXTRA_DESC", "Ini deskripsi detail untuk Custom Screen 1")
            intent.putExtra("EXTRA_FOOTER", "AppleApps")
            intent.putExtra("EXTRA_LOGO", R.drawable.apple)

            startActivity(intent)
        }

        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, Custom_2Activity::class.java)

            intent.putExtra("EXTRA_JUDUL", "Halaman Informasi")
            intent.putExtra("EXTRA_DESC", "Ini deskripsi detail untuk Custom Screen 2")
            intent.putExtra("EXTRA_FOOTER", "AppleApps")
            intent.putExtra("EXTRA_LOGO", R.drawable.apple)

            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}