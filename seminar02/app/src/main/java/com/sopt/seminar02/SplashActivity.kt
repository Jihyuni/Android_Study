package com.sopt.seminar02

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().apply {
            postDelayed({
              //  val intent : Intent = Intent(this@SplashActivity,MainActivity::class.java)
                //intent.putExtra("data1","헬로우")
                //intent.putExtra( "data2", "월드")
                //intent.putExtra("data3",1000)
                //startActivity(intent)

               startActivity<MainActivity>("data1" to "헬로우","data2" to "월드","data3" to 1000)
               finish()//피니쉬 안해주면 스플래쉬 액티비티 쌓임

            },2000)//ctr+p 들어갈 매개변수 알려줌 {람다식 함수}
        }
    }
}
