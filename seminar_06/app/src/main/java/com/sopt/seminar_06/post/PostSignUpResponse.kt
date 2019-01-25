package com.sopt.seminar_06.post

data class PostSignUpResponse(
        //null이 오면 굳이 받을 필요없음
        val status : String,
        val message : String
)
//서버 코드에서 중괄호 하나당 데이터클래스 하나