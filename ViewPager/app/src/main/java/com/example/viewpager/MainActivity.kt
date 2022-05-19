package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!
    private val tabTitleArray = arrayOf(
        "Monday", "Tuesday", "Wednesday"
    )
    private val tabIconArray = arrayOf(
        R.drawable.ic_baseline_arrow_back_24,
        R.drawable.ic_baseline_arrow_downward_24,
        R.drawable.ic_baseline_arrow_forward_24
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewPager = binding.viewpager
        var tabLayout = binding.tabLayout

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager){
            tab, position -> tab.text = tabTitleArray[position]
            tab.icon = getDrawable(tabIconArray[position])
        }.attach()
    }
}