package com.sopt.seminar02.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.seminar02.R

class HomeFragment : Fragment(){



    companion object {
        var mInstance : HomeFragment?=null
        @Synchronized //@임포트 되어야할 것들 알려주는 문법

        fun getInstance(): HomeFragment{
            if(mInstance==null){
                mInstance= HomeFragment()
            }
            return mInstance!!
        }
    }//static으로 메모리에ㅜ적재


//코틀린에서 물음표는 널 일 수 도 있다는 의미
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {// 리턴값 뷰
        val view : View= inflater!!.inflate(R.layout.fragment_home,container,false)

        return view
    }

}

