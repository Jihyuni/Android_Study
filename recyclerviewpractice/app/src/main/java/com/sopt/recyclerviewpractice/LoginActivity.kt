package com.sopt.recyclerviewpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sopt.recyclerviewpractice.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setBtnOnClickListener()

        if (SharedPreferenceController.getUserID(this).isNotEmpty()){
            startActivity<MainActivity>()
            finish()
        }
    }

    private fun setBtnOnClickListener(){

        btn_login_act_login.setOnClickListener{
            val input_id : String = et_login_act_id.text.toString()
            val input_pw : String = et_login_act_pw.text.toString()

            if(input_id.isNotEmpty()&&input_pw.isNotEmpty())
            {
                SharedPreferenceController.setUserID(this, input_id)
                SharedPreferenceController.setUserPW(this, input_pw)
            }

            startActivity<MainActivity>()


        }
    }


}
