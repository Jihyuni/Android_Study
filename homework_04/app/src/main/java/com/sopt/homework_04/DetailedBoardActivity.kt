package com.sopt.homework_04

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.sopt.homework_04.adapter.BoardRecyclerViewAdapter
import com.sopt.homework_04.data.BoardData
import com.sopt.homework_04.get.GetBoardContentResponse
import com.sopt.homework_04.get.GetBoardListResponse
import com.sopt.homework_04.network.ApplicationController
import com.sopt.homework_04.network.NetworkService
import kotlinx.android.synthetic.main.activity_detailed_board.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailedBoardActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    lateinit var boardRecyclerViewAdapter: BoardRecyclerViewAdapter
    val dataList: ArrayList<BoardData> by lazy {
        ArrayList<BoardData>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_board)

        setOnBtnClickListener()

    }

    private fun getBoardListResponse(){
        val getBoardListResponse = networkService.getBoardListResponse("application/json", 0, 30)
        getBoardListResponse.enqueue(object : Callback<GetBoardListResponse>{
            override fun onFailure(call: Call<GetBoardListResponse>, t: Throwable) {
                Log.e("board list fail", t.toString())
            }

            override fun onResponse(call: Call<GetBoardListResponse>, response: Response<GetBoardListResponse>) {
                if (response.isSuccessful){
                    val temp : ArrayList<BoardData> = response.body()!!.data
                    if (temp.size > 0){
                        val position = boardRecyclerViewAdapter.itemCount
                        boardRecyclerViewAdapter.dataList.addAll(temp)
                        boardRecyclerViewAdapter.notifyItemInserted(position)
                    }
                }
            }
        })
    }


    private fun setOnBtnClickListener() {
        btn_detailed_act_back.setOnClickListener {
            startActivity<BoardActivity>()
        }
    }
}
