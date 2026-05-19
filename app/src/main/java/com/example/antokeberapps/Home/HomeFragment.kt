package com.example.antokeberapps.Home

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.Pertemuan_6.WebViewActivity
import com.example.antokeberapps.R
import com.example.antokeberapps.databinding.FragmentHomeBinding
import com.example.antokeberapps.pertemuan_3.ThrdActivity
import com.example.antokeberapps.pertemuan_4.BRuangActivity
import com.example.antokeberapps.pertemuan_4.Custom_1Activity
import com.example.antokeberapps.pertemuan_4.Custom_2Activity
import com.example.antokeberapps.pertemuan_9.Pertemuan9Activity
import com.example.antokeberapps.pertemuan_9.SettingsActivity
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity)
            .supportActionBar?.title = "Dashboard"

        sharedPref = requireContext().getSharedPreferences(
            "user_pref",
            AppCompatActivity.MODE_PRIVATE
        )

        // Logout
        binding.btnLogout.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Konfirmasi Logout")
            builder.setMessage("Apakah Anda yakin ingin keluar?")

            builder.setPositiveButton("Iya") { dialog, _ ->
                sharedPref.edit().clear().apply()

                val intent = Intent(requireContext(), ThrdActivity::class.java)
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

                requireActivity().finish()
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

        // WebView
        binding.btnWeb.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        // Bangun Ruang
        binding.btnBangunRuang.setOnClickListener {
            val intent = Intent(requireContext(), BRuangActivity::class.java)
            intent.putExtra("EXTRA_FOOTER", "AppleApps")
            intent.putExtra("EXTRA_LOGO", R.drawable.apple)
            startActivity(intent)
        }

        // Custom 1
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(requireContext(), Custom_1Activity::class.java)
            intent.putExtra("EXTRA_JUDUL", "Halaman Informasi")
            intent.putExtra("EXTRA_DESC", "Ini deskripsi detail untuk Custom Screen 1")
            intent.putExtra("EXTRA_FOOTER", "AppleApps")
            intent.putExtra("EXTRA_LOGO", R.drawable.apple)
            startActivity(intent)
        }

        // Custom 2
        binding.btnCustom2.setOnClickListener {
            val intent = Intent(requireContext(), Custom_2Activity::class.java)
            intent.putExtra("EXTRA_JUDUL", "Halaman Informasi")
            intent.putExtra("EXTRA_DESC", "Ini deskripsi detail untuk Custom Screen 2")
            intent.putExtra("EXTRA_FOOTER", "AppleApps")
            intent.putExtra("EXTRA_LOGO", R.drawable.apple)
            startActivity(intent)
        }

        // Pertemuan 9
        binding.btnPertemuan9.setOnClickListener {
            startActivity(Intent(requireContext(), Pertemuan9Activity::class.java))
        }

        // Settings ListView
        binding.btnSettings.setOnClickListener {
            startActivity(Intent(requireContext(), SettingsActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}