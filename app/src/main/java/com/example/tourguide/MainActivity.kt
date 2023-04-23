package com.example.tourguide

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tourguide.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceAsColor")
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
                1 -> tab.text = "Fitness centers"
                2 -> tab.text = "Cinemas"
            }
            val customView = TextView(tabLayout.context).apply {
                text = tab.text
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f) // set font size to 20sp
                setTextColor(R.color.black)
                gravity = Gravity.CENTER
            }
            tab.customView = customView
        }.attach()
    }
}