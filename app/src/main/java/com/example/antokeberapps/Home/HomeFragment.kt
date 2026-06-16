package com.example.antokeberapps.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.antokeberapps.Data.Api.BeritaApiClient
import com.example.antokeberapps.Home.Berita.BeritaAdapter
import com.example.antokeberapps.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(binding.toolbar)

        binding.toolbar.title = "Dashboard Bina Desa"

        val adapter = HomeTabsAdapter(requireActivity())

        binding.viewPager.adapter = adapter

        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->

            when (position) {
                0 -> tab.text = "Edukasi"
                1 -> tab.text = "Layanan"
                2 -> tab.text = "Informasi"
            }

        }.attach()

        loadBerita()
    }

    private fun loadBerita() {

        viewLifecycleOwner.lifecycleScope.launch {

            try {

                val berita =
                    BeritaApiClient.apiService.getBerita()

                binding.rvBerita.layoutManager =
                    LinearLayoutManager(requireContext())

                binding.rvBerita.adapter =
                    BeritaAdapter(berita)

            } catch (e: Exception) {

                Toast.makeText(
                    requireContext(),
                    "Gagal memuat berita",
                    Toast.LENGTH_SHORT
                ).show()

                e.printStackTrace()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}