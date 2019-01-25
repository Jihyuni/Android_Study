package com.sopt.seminar02

import android.app.Activity
import android.app.DialogFragment
import android.app.Fragment
import android.app.FragmentTransaction
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.sopt.seminar02.fragment.HomeFragment
import com.sopt.seminar02.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    /* var data3 : Int = 0
    var data1 : String? =null
    var data2 : String?=null

    val REQUEST_CODE_USER_ACTIVITY = 1004

    var backPressedTime: Long = 0
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewClickListener()
        //val homeFragment1 : HomeFragment = HomeFragment()
        //val homeFragment2 : HomeFragment = HomeFragment()
        //val homeFragment3 : HomeFragment = HomeFragment()
        //val homeFragment00 : HomeFragment = HomeFragment.getInstance()
       // val homeFragment01 : HomeFragment = HomeFragment.getInstance()// 35,36 줄 같은 객체 의미

        //코틀린에서 싱글톤만드는 방법


        addFragment(HomeFragment.getInstance())
        replaceFragment(HomeFragment())

        btn_main_act_home_frag.setOnClickListener() {
            replaceFragment(HomeFragment())
        }

        btn_main_act_user_frag.setOnClickListener() {
            replaceFragment(UserFragment())
        }
/*
        //val data1 = intent.getStringExtra("data1")
        //val data2 = intent.getStringExtra("data2")
        //val data3 = intent.getStringExtra("data3")

     //   data1 = intent.getStringExtra("data1")

        //let 널체크 함수

      //  intent.getStringExtra("data2")?.let {
      //      data2 = it
      //  }

       // data3 = intent.getIntExtra("data3",0)

        btn_main_act_goto_sub.setOnClickListener{
            //버튼 눌렀을 때 수행할 로직 작성,회원가입 시작하기
            //startActivityForResult<SubActivity>(REQUEST_CODE_USER_ACTIVITY,"data1" to " 안녕하세요" )

            val intetnt : Intent = Intent(this, SubActivity::class.java)
            intetnt.putExtra("data1","안녕하세요")
            startActivityForResult(intent,REQUEST_CODE_USER_ACTIVITY)
        }


    }

    override fun onActivityResult(requestCode:Int,resultCode:Int,data:Intent?)
    {
        super.onActivityResult(requestCode,resultCode,data)

        if(requestCode==1004)
        {
            if(resultCode==100)
            {
                toast("결과코드 100")
            } else if(resultCode == 200)
            {
                toast("결과코드 200")
            } else if (resultCode== Activity.RESULT_OK)
            {
                toast("결과코드 RESULT_OK")
            }

        }
    }

    override fun onBackPressed() {
        var temp: Long = System.currentTimeMillis()
        var intervalTime: Long = temp - backPressedTime
        if (intervalTime in 0..2000) { super.onBackPressed()
        } else {
            backPressedTime = temp
            toast("버튼을 한번 더 누르면 종료됩니다.")
        }
    }*/
    }
    private fun setViewClickListener() { btn_main_act_home_frag.setOnClickListener {
        replaceFragment(HomeFragment())
    }
        btn_main_act_user_frag.setOnClickListener { replaceFragment(UserFragment())
        }
    }


    private fun addFragment(fragment: android.support.v4.app.Fragment) {
        //트랜잭션- 꼬이지않게 하기위해 사용

        val transaction: android.support.v4.app.FragmentTransaction? = supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.fl_main_act_fragment, fragment)
        transaction.commit()
    }

    private fun replaceFragment(fragment: android.support.v4.app.Fragment) {
        //트랜잭션- 꼬이지않게 하기위해 사용

        val transaction: android.support.v4.app.FragmentTransaction? = supportFragmentManager.beginTransaction()
        transaction!!.replace(R.id.fl_main_act_fragment, fragment)
        transaction.commit()
    }


}