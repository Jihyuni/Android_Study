package com.sopt.seminar_04.db

import android.content.Context
import android.content.SharedPreferences
object SharedPreferenceController {
    private val USER_NAME: String = "user_name"
    private val USER_ID: String = "user_id"
    private val USER_PW: String = "user_pw"
    //ID 집어 넣기
    fun setUserID(ctx: Context, input_id: String) {
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString(USER_ID, input_id)
        editor.commit()
    }
    //PW 집어 넣기
    fun setUserPW(ctx: Context, input_pw: String) {
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString(USER_PW, input_pw)
        editor.commit()
    }
    //ID 꺼내기
    fun getUserID(ctx: Context): String {
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        return preference.getString(USER_ID, "") // (키 명, 든게 없을때 리턴할 값)
    }
    //PW 꺼내기
    fun getUserPW(ctx: Context): String {
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        return preference.getString(USER_PW, "") // (키 명, 든게 없을때 리턴할 값)
    }

    //user_name 모든 데이터 제거
    fun clearUserSharedPreferences(ctx: Context) {
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.clear()
        editor.commit()
    }
}
