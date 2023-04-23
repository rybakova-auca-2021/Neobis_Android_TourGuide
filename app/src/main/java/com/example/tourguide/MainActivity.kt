package com.example.tourguide

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tourguide.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
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

        // Set white text color for all tabs
        val whiteTextColor = ContextCompat.getColor(this, R.color.white)
        tabLayout.setTabTextColors(whiteTextColor, whiteTextColor)

        // Set listener to change text color of selected tab
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Set black text color for selected tab
                val customView = tab?.customView as? TextView
                customView?.setTextColor(Color.BLACK)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Set white text color for unselected tabs
                val customView = tab?.customView as? TextView
                customView?.setTextColor(whiteTextColor)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Do nothing
            }
        })

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Restaurants"
                1 -> tab.text = "Fitness centers"
                2 -> tab.text = "Cinemas"
            }
            // set the text appearance to a larger font size and white text color
            val customView = TextView(tabLayout.context).apply {
                text = tab.text
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                setTextColor(whiteTextColor)
                gravity = Gravity.CENTER
            }
            tab.customView = customView
        }.attach()
    }
}
