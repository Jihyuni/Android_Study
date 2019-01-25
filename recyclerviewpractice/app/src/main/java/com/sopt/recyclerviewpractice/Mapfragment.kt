package com.sopt.recyclerviewpractice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.recyclerviewpractice.adapter.KakaoRecyclerViewAdapter
import com.sopt.recyclerviewpractice.adapter.MemoRecyclerViewAdapter
import com.sopt.recyclerviewpractice.data.kakaoroomData
import com.sopt.recyclerviewpractice.data.memoData
import kotlinx.android.synthetic.main.mainfragment.*
import kotlinx.android.synthetic.main.mapfragment.*
import org.jetbrains.anko.support.v4.startActivity

class Mapfragment : Fragment() {

    lateinit var memoRecyclerViewAdapter: MemoRecyclerViewAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mapfragment, container, false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()

        btn_map_fragment_write.setOnClickListener{
            if (et_map_fragment_title.text.toString().isNotEmpty() && et_map_fragment_content.text.toString().isNotEmpty()){
                val position = memoRecyclerViewAdapter.itemCount
                memoRecyclerViewAdapter.dataList.add(memoData(et_map_fragment_title.text.toString(), et_map_fragment_content.text.toString()))
                //recycMemoRecyclerViewAdapter.notifyDataSetChanged()
                memoRecyclerViewAdapter.notifyItemInserted(position)

            }
        }

    }


    private fun setRecyclerView(){
        var dataList: ArrayList<memoData> = ArrayList()
        dataList.add(memoData("제목-1","안녕"))
        dataList.add(memoData("제목-1","안녕"))




        memoRecyclerViewAdapter = MemoRecyclerViewAdapter(activity!!,dataList)
        rv_map_fragment.adapter = memoRecyclerViewAdapter
        rv_map_fragment.layoutManager = LinearLayoutManager(activity)

    }


}