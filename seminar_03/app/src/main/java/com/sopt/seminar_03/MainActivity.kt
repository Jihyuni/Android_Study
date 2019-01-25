package com.sopt.seminar_03

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.sopt.seminar_03.R.id.container
import com.sopt.seminar_03.adapter.KakaoTalkRoomRecyclerViewAdapter
import com.sopt.seminar_03.adapter.MyFragmentStatePagerAdapter
import com.sopt.seminar_03.data.KakaoTalkRoomData
import kotlinx.android.synthetic.main.activity_bottom_navi.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    lateinit var kakaoTalkRoomRecyclerViewAdapter: KakaoTalkRoomRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}