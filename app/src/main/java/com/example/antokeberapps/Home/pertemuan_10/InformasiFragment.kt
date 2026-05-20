package com.example.antokeberapps.Home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.antokeberapps.R
import com.example.antokeberapps.databinding.FragmentInformasiBinding
import kotlin.jvm.java
import com.example.antokeberapps.DataFoto.DataFotoActivity
class InformasiFragment : Fragment(
    R.layout.fragment_informasi
) {

    private var _binding: FragmentInformasiBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentInformasiBinding.bind(view)

        binding.btnDokum.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    DataFotoActivity::class.java
                )
            )
        }
    }
}