package com.example.antokeberapps.Home.pertemuan_3

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.R
import java.util.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etTanggal = findViewById<EditText>(R.id.etTanggal)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val spAgama = findViewById<Spinner>(R.id.spAgama)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirm = findViewById<EditText>(R.id.etConfirm)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val agamaList = arrayOf("Pilih Agama", "Islam", "Kristen", "Hindu", "Buddha")
        spAgama.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, agamaList)

        etTanggal.setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(this,
                { _, y, m, d -> etTanggal.setText("$d/${m + 1}/$y") },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        btnRegister.setOnClickListener {

            val nama = etNama.text.toString()
            val tanggal = etTanggal.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirm = etConfirm.text.toString()

            if (nama.isEmpty()) { etNama.error = "Isi nama"; return@setOnClickListener }
            if (tanggal.isEmpty()) { etTanggal.error = "Isi tanggal"; return@setOnClickListener }
            if (rgGender.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih gender", Toast.LENGTH_SHORT).show(); return@setOnClickListener
            }
            if (spAgama.selectedItemPosition == 0) {
                Toast.makeText(this, "Pilih agama", Toast.LENGTH_SHORT).show(); return@setOnClickListener
            }
            if (username.isEmpty()) { etUsername.error = "Isi username"; return@setOnClickListener }
            if (password.isEmpty()) { etPassword.error = "Isi password"; return@setOnClickListener }
            if (confirm.isEmpty()) { etConfirm.error = "Isi confirm"; return@setOnClickListener }
            if (password != confirm) { etConfirm.error = "Tidak sama"; return@setOnClickListener }

            val sp = getSharedPreferences("dataUser", MODE_PRIVATE)
            sp.edit()
                .putString("username", username)
                .putString("password", password)
                .apply()

            Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}