package com.sopt.recyclerviewpractice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.recyclerviewpractice.adapter.KakaoRecyclerViewAdapter
import com.sopt.recyclerviewpractice.adapter.commentRecyclerViewAdapter
import com.sopt.recyclerviewpractice.data.commentData
import com.sopt.recyclerviewpractice.data.kakaoroomData
import com.sopt.recyclerviewpractice.get.GetBoardListResponse
import com.sopt.recyclerviewpractice.network.ApplicationController
import com.sopt.recyclerviewpractice.network.NetworkService
import kotlinx.android.synthetic.main.mainfragment.*
import kotlinx.android.synthetic.main.rv_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Mainfragment : Fragment() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    lateinit var kakaoRecyclerViewAdapter: KakaoRecyclerViewAdapter
    lateinit var CommentRecyclerViewAdapter: commentRecyclerViewAdapter
    val dataList : ArrayList<kakaoroomData> by lazy {
        ArrayList<kakaoroomData>()
    }

    val commentdataList : ArrayList<commentData> by lazy {
        ArrayList<commentData>()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.mainfragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRecyclerView()

        iv_rv_photo.setOnClickListener{

            CommentRecyclerViewAdapter = commentRecyclerViewAdapter(activity!!,commentdataList)
            rv_comment.adapter = CommentRecyclerViewAdapter
            rv_comment.layoutManager = LinearLayoutManager(activity)
        }
        getBoardListResponse()
    }

    private fun setRecyclerView(){

        kakaoRecyclerViewAdapter = KakaoRecyclerViewAdapter(activity!!,dataList)
        rv_main_frag_kakao_talk_room_list.adapter = kakaoRecyclerViewAdapter
        rv_main_frag_kakao_talk_room_list.layoutManager = LinearLayoutManager(activity)


    }

    private fun getBoardListResponse(){
        val myToken = SharedPreferenceController.getAuthorization()
        val getBoardListResponse = networkService.getBoardListResponse("application/json",myToken )
        getBoardListResponse.enqueue(object : Callback<GetBoardListResponse> {
            override fun onFailure(call: Call<GetBoardListResponse>, t: Throwable) { Log.e("board list fail", t.toString())
            }
            override fun onResponse(call: Call<GetBoardListResponse>, response: Response<GetBoardListResponse>) {
                if (response.isSuccessful){
                    val temp : ArrayList<kakaoroomData> = response.body()!!.data
                    if (temp.size > 0){
                        val position = kakaoRecyclerViewAdapter.itemCount
                        kakaoRecyclerViewAdapter.dataList.addAll(temp)
                        kakaoRecyclerViewAdapter.notifyItemInserted(position)
                    }

                }
            } })
    }
}