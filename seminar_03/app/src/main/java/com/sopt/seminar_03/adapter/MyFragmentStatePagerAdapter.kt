package com.sopt.seminar_03.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.sopt.seminar_03.fragment.MainFragment
import com.sopt.seminar_03.fragment.MapFragment
import com.sopt.seminar_03.fragment.MypageFragment

class MyFragmentStatePagerAdapter(fm : FragmentManager,val FragmentCount : Int) : FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment? {
        when(position)
        {
            0->return MainFragment()
            1->return MapFragment()
            2->return MypageFragment()
            else->return null
        }
    }

    override fun getCount(): Int = FragmentCount



}
