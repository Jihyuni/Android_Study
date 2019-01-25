package com.sopt.homework02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {


    val REQUEST_CODE=1004
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnBtnClickListener()



    }

    private fun setOnBtnClickListener() {
        btn_main_act_sign_in.setOnClickListener {
            toast("로그인")
        }

        btn_main_act_sign_up.setOnClickListener{
            var inputId :String = et_main_act_id.text.toString()

            startActivityForResult<SignUpActivity>(REQUEST_CODE,"id" to inputId)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    var id = data.getStringExtra("id")
                    et_sign_up_act_id.setText(id)

                }

            }
        }
    }



}
