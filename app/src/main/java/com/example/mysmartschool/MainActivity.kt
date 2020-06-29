package com.example.mysmartschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mysmartschool.MyWork.MyWorkFragment
import com.example.mysmartschool.SmartVideo.SmartVideo
import com.example.mysmartschooll.SmartInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()

        transFragment(HomeFragment())
    }

    public fun transFragment(fragment: Fragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace(R.id.main_frame, fragment).commit()
    }

    private fun initComponent() {
        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    transFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_myvideo -> {
                    transFragment(SmartVideo())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_mywork -> {
                    transFragment(MyWorkFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_smartinfo -> {
                    transFragment(SmartInfo())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }
}
