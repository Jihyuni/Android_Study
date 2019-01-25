package com.sopt.fragment.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.sopt.fragment.R
import com.sopt.fragment.fragment.SecondFragmentn
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        setOnClickListener()
        addFragment(FirstFragment()) //인스턴스 생성  new--
        val second1 : SecondFragmentn= SecondFragmentn()
        val second2 : SecondFragmentn=SecondFragmentn()
        // 둘은 다른 객체 -> 각 객체 안에 있는 number 변수는 다름
          }

    private fun setOnClickListener(){
        btn_sub_act_first.setOnClickListener(){
            replaceFragment(FirstFragment())

        }
        btn_sub_act_second.setOnClickListener(){
            replaceFragment(SecondFragmentn())
        }
    }

    private fun addFragment(fragment:Fragment)
    {
        val transaction : FragmentTransaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_sub_act_fragment,fragment)
        transaction.commit()
    }
    private fun replaceFragment(fragment: Fragment)
    {
        val transaction: FragmentTransaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_sub_act_fragment,fragment)
        transaction.commit()
    }
}
