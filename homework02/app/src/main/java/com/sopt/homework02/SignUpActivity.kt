package com.sopt.homework02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setInitText()
        setOnBtnClickListener()

    }

    private fun setInitText(){
        var id : String? = intent.getStringExtra("id")

        et_sign_up_act_id.setText(id)

    }
    private fun setOnBtnClickListener(){
        btn_sign_up_act_close.setOnClickListener()
        {
            finish()
        }
        btn_sign_up_act_complete.setOnClickListener(){
            var intent : Intent = Intent()
            intent.putExtra("id",et_sign_up_act_id.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()

        }

    }

}
