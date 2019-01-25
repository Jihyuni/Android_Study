package com.sopt.homework_04.get

import com.sopt.homework_04.data.BoardData

data class GetBoardListResponse(
        val status : Int,
        val message : String,
        val data : ArrayList<BoardData>
)

data class GetBoardContentResponse(
        val status : Int,
        val message : String,
        val data : ArrayList<BoardData>
)