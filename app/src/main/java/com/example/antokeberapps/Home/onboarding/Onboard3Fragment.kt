package com.example.antokeberapps.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.antokeberapps.Home.pertemuan_3.ThirdResultActivity
import com.example.antokeberapps.databinding.FragmentOnboard3Binding
import kotlin.jvm.java

class Onboard3Fragment : Fragment() {

    private var _binding: FragmentOnboard3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOnboard3Binding.inflate(inflater, container, false)

        binding.btnMulai.setOnClickListener {

            val intent = Intent(
                requireContext(),
                ThirdResultActivity::class.java
            )

            startActivity(intent)
            requireActivity().finish()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}