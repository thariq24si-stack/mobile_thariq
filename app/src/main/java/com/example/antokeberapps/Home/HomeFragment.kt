package com.example.antokeberapps.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.antokeberapps.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity)
        binding.toolbar.title = "Dashboard Bina Desa"

        val adapter = HomeTabsAdapter(
            requireActivity()
        )

        binding.viewPager.adapter = adapter

        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ){ tab, position ->

            when(position){

                0 -> tab.text = "Edukasi"
                1 -> tab.text = "Layanan"
                2 -> tab.text = "Informasi"
            }

        }.attach()
    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }
}