package com.delaroystudios.recyclerviewfragment

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.delaroystudios.recyclerviewfragment.BlankFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar


        val viewPager = findViewById(R.id.viewpager) as ViewPager
        val pagerAdapter = PagerAdapter(supportFragmentManager, this@MainActivity)
        viewPager.adapter = pagerAdapter

        val tabLayout = findViewById(R.id.tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)

        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            tab!!.customView = pagerAdapter.getTabView(i)
        }

    }

    public override fun onResume() {
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    internal inner class PagerAdapter(fm: FragmentManager, var context: Context) : FragmentPagerAdapter(fm) {

        var tabTitles = arrayOf("First Tab", "Second Tab", "Third Tab")

        override fun getCount(): Int {
            return tabTitles.size
        }

        override fun getItem(position: Int): Fragment? {

            when (position) {
                0 -> return BlankFragment()
                1 -> return BlankFragment()
                2 -> return BlankFragment()
            }

            return null
        }


        override fun getPageTitle(position: Int): CharSequence {
            return tabTitles[position]
        }

        fun getTabView(position: Int): View {
            val tab = LayoutInflater.from(this@MainActivity).inflate(R.layout.custom_tab, null)
            val tv = tab.findViewById(R.id.custom_text) as TextView
            tv.text = tabTitles[position]
            return tab
        }
    }
}