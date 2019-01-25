package com.sopt.recyclerviewpractice.adapter

import android.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import com.sopt.recyclerviewpractice.Mainfragment
import com.sopt.recyclerviewpractice.Mapfragment
import com.sopt.recyclerviewpractice.MyPagefragment

class MyStatePagerAdapter(fm : android.support.v4.app.FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm){

    override fun getItem(p0: Int): Fragment? {
        when(p0){
            0-> return Mainfragment()
            1-> return MyPagefragment()
            2-> return Mapfragment()
            else-> return null
        }
    }

    override fun getCount(): Int = fragmentCount
}
