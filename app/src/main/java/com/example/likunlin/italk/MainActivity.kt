package com.example.likunlin.italk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.likunlin.italk.talk.talk
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import com.example.likunlin.italk.firebase.user
import com.example.likunlin.italk.fragment.disscuss_Fragment
import com.example.likunlin.italk.fragment.friends_Fragment
import com.example.likunlin.italk.fragment.main_Fragment
import com.example.likunlin.italk.fragment.message_Fragment


class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {

    private var viewPager: ViewPager? = null
    private var tabLayout: TabLayout? = null

    private val fragment_main = main_Fragment()
    private val fragment_disscuss = disscuss_Fragment()
    private val fragment_message = message_Fragment()
    private val fragment_friend = friends_Fragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout

        viewPager!!.addOnPageChangeListener(this)
        tabLayout!!.addOnTabSelectedListener(this)

        //添加适配器，在viewPager里引入Fragment
        viewPager!!.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment? {
                when (position) {
                    0 -> return fragment_main
                    1 -> return fragment_friend
                    2 -> return fragment_message
                    3 -> return fragment_disscuss
                }
                return null
            }

            override fun getCount(): Int {
                return 4
            }
        }

    }

    override fun onTabSelected(tab: TabLayout.Tab) {
        viewPager!!.currentItem = tab.position

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

        tabLayout!!.getTabAt(position)!!.select()
    }

    override fun onPageScrollStateChanged(state: Int) {

    }
}