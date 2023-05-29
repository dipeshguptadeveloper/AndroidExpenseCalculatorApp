package com.dkgtech.expensecalulatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.dkgtech.expensecalulatorapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fm: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fm = supportFragmentManager
        loadFrag(HomeFragment(), true)

        binding.bnView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bn_menu_Home -> {
                    loadFrag(HomeFragment(), false)
                }

                R.id.bn_menu_chart -> {
                    loadFrag(ChartFragment(), false)
                }

                else -> {
                    loadFrag(SettingFragment(), false)
                }
            }
            true
        }

    }

    private fun loadFrag(frag: Fragment, flag: Boolean) {
        val ft = fm.beginTransaction()
        if (flag) {
            ft.add(R.id.container, frag)
        } else {
            ft.replace(R.id.container, frag)
        }
        ft.commit()
    }
}