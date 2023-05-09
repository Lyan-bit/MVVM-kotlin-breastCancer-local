package com.example.breastcancerlocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.breastcancerlocal.adapter.SectionsPagerAdapter
import com.example.breastcancerlocal.fragments.ListFragment
import com.example.breastcancerlocal.model.BreastCancerVO
import com.example.breastcancerlocal.viewmodel.BreastCancerViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), ListFragment.OnListFragmentInteractionListener {

    private lateinit var model: BreastCancerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewpager: ViewPager = findViewById(R.id.view_pager)
        viewpager.adapter = myPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewpager)
        model = BreastCancerViewModel.getInstance(this)
    }

    override fun onListFragmentInteraction(item: BreastCancerVO) {
        model.setSelectedBreastCancer(item)
    }
}