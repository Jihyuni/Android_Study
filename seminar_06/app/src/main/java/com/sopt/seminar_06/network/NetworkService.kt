package com.sopt.seminar_06.network
import com.google.gson.JsonObject
import com.sopt.seminar_06.get.GetBoardContentResponse
import com.sopt.seminar_06.get.GetBoardListResponse
import com.sopt.seminar_06.post.PostLogInResponse
import com.sopt.seminar_06.post.PostSignUpResponse
import com.sopt.seminar_06.post.PostWriteBoardResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface NetworkService {


        @POST("/users")
        //폼형식 (서버개발자마다 받고자하는 형식이 다름, 파라미터 형식으로 받고자 하는 개발자도 있음-필드마다 데이터 형식 넣)

        fun postSignUpResponse(
                @Header("Content-Type") content_type : String,
                @Body() body : JsonObject
        ) : Call<PostSignUpResponse>

        @POST("/login")
        fun postLogInResponse(
                @Header("Content-Type") content_type : String,
                @Body() body : JsonObject
        ) : Call<PostLogInResponse>

        @Multipart
        @POST("/contents")
        fun postWriteBoardResponse(
                @Header("Authorization") token : String,
                @Part("title") title : RequestBody,
                @Part("contents") contents : RequestBody,
                @Part photo: MultipartBody.Part?
        ) : Call<PostWriteBoardResponse>

        @GET("/contents")
        fun getBoardListResponse(
                @Header("Content-Type") content_type : String,
                @Query("offset") offset : Int,
                @Query("limit") limit : Int
        ) : Call<GetBoardListResponse>

        @GET("/contents")
        fun getBoardContentResponse(
                @Header("Content-Type") content_type : String,
                @Header("Authorization") token : String,
                @Path("contentIdx") contentIdx : Int
        ) : Call<GetBoardContentResponse>
    }



