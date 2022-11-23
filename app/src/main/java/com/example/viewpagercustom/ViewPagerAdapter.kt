package com.example.viewpagercustom

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//Create a class extending from FragmentStateAdapter to swipe Fragments
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

//    getItemCount(): This method returns the total number of items in the Adapter.

    override fun getItemCount(): Int {
        return 4
    }

    //    createFragment(position: Int): This method returns a Fragment instance for the given position.
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()
        }
    }
}