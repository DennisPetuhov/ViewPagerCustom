package com.example.viewpagercustom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.viewpagercustom.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
val animalsArray = arrayOf(
    "Cat",
    "animation1",
    "Animation2"
)
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tabLayoutTab, position->
            tabLayoutTab.text = animalsArray[position]

        }.attach()

    }}