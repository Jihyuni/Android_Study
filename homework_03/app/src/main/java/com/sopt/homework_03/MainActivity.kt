package com.sopt.homework_03

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.RelativeLayout
import com.sopt.homework_03.adapter.rvAdapter
import com.sopt.homework_03.data.Viewdata
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rv_item.*

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setRecyclerView()


    }


    lateinit var Adapter: rvAdapter


    private fun setRecyclerView(){
        var dataList: ArrayList<Viewdata> = ArrayList()

        dataList.add(Viewdata(1, false))
        dataList.add(Viewdata(2, false))
        dataList.add(Viewdata(3, false))
        dataList.add(Viewdata(4, false))
        dataList.add(Viewdata(5, false))
        dataList.add(Viewdata(6, false))
        dataList.add(Viewdata(7, false))
        dataList.add(Viewdata(8, false))
        dataList.add(Viewdata(9, false))
        dataList.add(Viewdata(10, false))
        dataList.add(Viewdata(11, false))
        dataList.add(Viewdata(12, false))
        dataList.add(Viewdata(13, false))
        dataList.add(Viewdata(14, false))
        dataList.add(Viewdata(15, false))


        Adapter= rvAdapter(this!!,dataList)
        rv_main_act_list.adapter=Adapter
        rv_main_act_list.layoutManager= GridLayoutManager(this,3)

    }







}
