package com.example.antokeberapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.antokeberapps.About.AboutFragment
import com.example.antokeberapps.Home.HomeFragment
import com.example.antokeberapps.Profile.ProfileFragment
import com.example.antokeberapps.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_base)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Fragment default
        replaceFragment(HomeFragment())


        binding.bottomNavView.setOnItemSelectedListener {


            when (it.itemId) {


                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }


                R.id.about -> {
                    replaceFragment(AboutFragment())
                    true
                }


                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }


                else -> false
            }
        }
    }


    private fun replaceFragment(fragment: Fragment) {


        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}
