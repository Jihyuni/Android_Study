package com.sopt.recyclerviewpractice.get

import com.sopt.recyclerviewpractice.data.PhotoData
import com.sopt.recyclerviewpractice.data.kakaoroomData


data class GetBoardListResponse(
        val contentIdx : Int,
        val userIdx : Int,
        val photo : ArrayList<PhotoData>,
        val body : String,
        val likeCount : Int,
        val createDate : String,
        val auth : Boolean,
        val like : Boolean

)

