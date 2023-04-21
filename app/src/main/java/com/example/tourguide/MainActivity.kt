package com.example.tourguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tourguide.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val tabLayout = binding.tabLayout
        val viewPager2 = binding.fragmentHolder

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2){tab, position ->
            when(position){
                0 -> tab.text = "Restaurants"
                1 -> tab.text = "Gym centers"
                2 -> tab.text = "Cinemas"
            }
        }.attach()
    }
}