package com.example.viewpagercustom

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.example.viewpagercustom.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

val animalsArray: List<TabObject> = TabObjectData.tabList

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initPager(animalsArray)


    }

    fun initPager(list:List<TabObject>) {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tabLayoutTab, position ->

            val view = layoutInflater.inflate(R.layout.tab_item_layout,null,false)
            view.findViewById<ImageView>(R.id.image_directory).setImageResource(list[position].pic)
            view.findViewById<TextView>(R.id.textView).text= list[position].text
            tabLayoutTab.apply {
                customView=view
                if (position==0){
                    customView?.apply {

                        findViewById<ImageView>(R.id.circle).setColorFilter(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.orange
                            )


                        )
                        findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#FF6E4E"))
                        findViewById<ImageView>(R.id.image_directory).setColorFilter(
                            ContextCompat.getColor(
                               this@MainActivity,
                                R.color.white
                            )
                        )

                    }
                }

            }


        }.attach()


        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{


            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.apply {
                    findViewById<ImageView>(R.id.circle).setColorFilter(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.orange
                        ))
                    findViewById<ImageView>(R.id.image_directory).setColorFilter(
                        ContextCompat.getColor(this@MainActivity,R.color.white)
                    )
                    findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#FF6E4E"))

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.apply {
                    tab?.customView?.apply {
                        findViewById<ImageView>(R.id.circle).setColorFilter(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.white
                            ))
                        findViewById<ImageView>(R.id.image_directory).setColorFilter(
                            ContextCompat.getColor(this@MainActivity,R.color.tab_layout_icon_color)
                        )
                        findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#B3B3C3"))

                    }

                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }
}