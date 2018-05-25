package com.tech_crunch.hackaton.vabama

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.tech_crunch.hackaton.vabama.fragment.PageFragment
import com.tech_crunch.hackaton.vabama.data.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = MyFragmentPagerAdapter(supportFragmentManager)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_all -> viewPager.currentItem = 0
                R.id.item_painting -> viewPager.currentItem = 1
                R.id.item_repair -> viewPager.currentItem = 2
                R.id.item_cleaning -> viewPager.currentItem = 3
            }
            true
        }
    }

    private inner class MyFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> PageFragment.newInstance(ALL_STATUS)
                1 -> PageFragment.newInstance(NEED_PAINTING_STATUS)
                2 -> PageFragment.newInstance(NEED_REPAIR_STATUS)
                3 -> PageFragment.newInstance(NEED_CLEANING_STATUS)
                else -> PageFragment.newInstance(ALL_STATUS)
            }
        }

        override fun getCount(): Int {
            return 4
        }

    }

}
