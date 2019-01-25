package com.sopt.seminar_08

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(MyFragment.getInstance("안녕하세요","송지현입니다."))

    }

    private fun addFragment(fragment : Fragment){
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_main_act_fragment, fragment)
        transaction.commit()
    }

    private fun setOnclickListener(){
        btn_main_act_show_first_dialog.setOnClickListener(){

        }
    }
}
