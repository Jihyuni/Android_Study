package com.sopt.recyclerviewpractice.network

import com.sopt.recyclerviewpractice.get.GetBoardListResponse
import retrofit2.Call
import retrofit2.http.*


interface NetworkService {



        @GET("/contents")
        fun getBoardListResponse(
                @Header("Content-Type") content_type : String,
                @Header("Authorization") token : String

        ) : Call<GetBoardListResponse>


    }



