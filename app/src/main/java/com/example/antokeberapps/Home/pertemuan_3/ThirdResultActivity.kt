package com.example.antokeberapps.Home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.databinding.ActivityThirdResultBinding
import com.example.antokeberapps.pertemuan_4.DashboardActivity

class ThirdResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔹 LOGIN BUTTON
        binding.button2.setOnClickListener {

            val username = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()

            val sp = getSharedPreferences("dataUser", MODE_PRIVATE)
            val savedUser = sp.getString("username", "")
            val savedPass = sp.getString("password", "")

            if (username.isEmpty()) {
                binding.editTextTextEmailAddress.error = "Username wajib diisi"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.editTextTextPassword.error = "Password wajib diisi"
                return@setOnClickListener
            }

            // RULE 1
            if (username == password) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardActivity::class.java))
            }
            // RULE 2
            else if (username == savedUser && password == savedPass) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                binding.editTextTextPassword.error = "Username / Password salah"
            }
        }

        // 🔹 REGISTER BUTTON
        binding.button3.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}