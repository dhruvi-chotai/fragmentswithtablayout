package com.example.fragment_with_tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        val adapter = ViewPageAdapter(this)
        adapter.addFragment(OneFragment())
        adapter.addFragment(TwoFragment())
        adapter.addFragment(ThreeFragment())
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){tab, position ->
            when (position){
                0 -> tab.text = "Fragment One"
                1 -> tab.text = "Fragment Two"
                2 -> tab.text = "Fragment Three"
            }
        }.attach()


    }
}