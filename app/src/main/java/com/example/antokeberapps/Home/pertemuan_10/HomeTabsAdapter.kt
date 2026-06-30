package com.example.antokeberapps.Home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeTabsAdapter(
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {

        return when(position){

            0 -> EdukasiFragment()
            1 -> LayananFragment()
            2 -> InformasiFragment()
            3 -> ReminderFragment()

            else -> EdukasiFragment()
        }
    }
}