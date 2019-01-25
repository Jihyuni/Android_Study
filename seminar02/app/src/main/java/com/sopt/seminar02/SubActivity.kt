package com.sopt.seminar02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

       /* btn_main_act_goto_sub.setOnClickListener {
            //버튼 누렀응ㄹ 때 수행될 로직
            (it as Button).text="닫기"
            val intent: Intent = Intent()
            intent.putExtra("resultData", "User에서 보내는 결과 데이터")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
*/
    }
}
