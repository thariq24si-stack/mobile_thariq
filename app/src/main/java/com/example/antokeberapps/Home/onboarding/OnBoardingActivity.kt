package com.example.antokeberapps.Home.onboarding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.antokeberapps.R
import com.example.antokeberapps.databinding.ActivityOnBoardingBinding
import com.example.antokeberapps.onboarding.Onboard1Fragment
import com.example.antokeberapps.onboarding.Onboard2Fragment
import com.example.antokeberapps.onboarding.Onboard3Fragment
import com.example.antokeberapps.onboarding.OnboardAdapter

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(
            Onboard1Fragment(),
            Onboard2Fragment(),
            Onboard3Fragment()
        )

        val adapter = OnboardAdapter(this, fragments)

        binding.viewPager.adapter = adapter

        binding.dotsIndicator.attachTo(binding.viewPager)
    }
}