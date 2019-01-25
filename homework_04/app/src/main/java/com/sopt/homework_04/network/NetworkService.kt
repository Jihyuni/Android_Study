package com.sopt.homework_04.network

import android.telecom.Call
import com.sopt.homework_04.get.GetBoardContentResponse
import com.sopt.homework_04.get.GetBoardListResponse
import com.sopt.homework_04.post.PostWriteBoardResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


interface NetworkService {
    @Multipart
    @POST("/contents")
    fun postWriteBoardResponse(
            @Header("Authorization") token : String,
            @Part("title") title : RequestBody,
            @Part("contents") contents : RequestBody,
            @Part photo: MultipartBody.Part?
    ) : retrofit2.Call<PostWriteBoardResponse>

    @GET("/contents")
    fun getBoardListResponse(
            @Header("Content-Type") content_type : String,
            @Query("offset") offset : Int,
            @Query("limit") limit : Int
    ) : retrofit2.Call<GetBoardListResponse>

    @GET("/contents")
    fun getBoardContentResponse(
            @Header("Content-Type") content_type : String,
            @Query("Authorization") token: String
    ) : retrofit2.Call<GetBoardContentResponse>

}
