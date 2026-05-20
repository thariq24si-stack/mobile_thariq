package com.example.antokeberapps.Home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.antokeberapps.R
import com.example.antokeberapps.databinding.FragmentEdukasiBinding
import com.example.antokeberapps.pertemuan_4.BRuangActivity
import com.example.antokeberapps.pertemuan_9.Pertemuan9Activity

class EdukasiFragment : Fragment(
    R.layout.fragment_edukasi
) {

    private var _binding: FragmentEdukasiBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentEdukasiBinding.bind(view)

        binding.btnBangunRuang.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    BRuangActivity::class.java
                )
            )
        }

        binding.btnPertemuan9.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    Pertemuan9Activity::class.java
                )
            )
        }
    }
}