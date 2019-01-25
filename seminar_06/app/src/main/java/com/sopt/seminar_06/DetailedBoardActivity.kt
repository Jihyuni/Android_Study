package com.sopt.seminar_06

import android.app.Activity
import android.app.SharedElementCallback
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.sopt.seminar_06.adapter.BoardRecyclerViewAdapter
import com.sopt.seminar_06.data.BoardData
import com.sopt.seminar_06.db.SharedPreferenceController
import com.sopt.seminar_06.get.GetBoardContentResponse
import com.sopt.seminar_06.get.GetBoardListResponse
import com.sopt.seminar_06.network.ApplicationController
import com.sopt.seminar_06.network.NetworkService
import kotlinx.android.synthetic.main.activity_detailed_board.*
import kotlinx.android.synthetic.main.rv_item_board.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailedBoardActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_board)

        val b_id = intent.getIntExtra("b_id", -1)
        getBoardContentResponse(b_id)


        setBtnOnClickListener()
    }

    private fun getBoardContentResponse(board_id : Int){

        val myToken = SharedPreferenceController.getAuthorization(this)
        val getBoardContentResponse = networkService.getBoardContentResponse("application/json", myToken, board_id)

        getBoardContentResponse.enqueue(object : Callback<GetBoardContentResponse> {
            override fun onFailure(call: Call<GetBoardContentResponse>, t: Throwable) {
                Log.e("board Content fail", t.toString())
            }
            override fun onResponse(call: Call<GetBoardContentResponse>, response: Response<GetBoardContentResponse>) {
                if (response.isSuccessful){

                    val title = response.body()!!.data.b_title
                    val content  = response.body()!!.data.b_contents
                    val image = response.body()!!.data.b_photo

                    setDetailedBoardView(title, content, image)
                }
            } })
    }



    private fun setDetailedBoardView(title : String?, contents : String?, image : String?){
        title?.let {
            tv_detailed_act_title2.text = title
        }
        contents?.let {
            tv_detailed_act_content2.text = contents
        }
        image?.let {
            Glide.with(this).load(image).into(iv_detailed_act_image)
        }

    }
    private fun setBtnOnClickListener(){
        btn_detailed_act_back.setOnClickListener(){
            finish()
        }
    }



}
