package com.sopt.lottoactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random
import java.nio.file.Files.find
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_main_act_makenum.setOnClickListener(){

        }
        btn_clear.setOnClickListener(){
            tv_main_act_num1.setText("0")
            tv_main_act_num2.setText("0")
            tv_main_act_num3.setText("0")
            tv_main_act_num4.setText("0")
            tv_main_act_num5.setText("0")
            tv_main_act_num6.setText("0")
        }

    }



    var random = Random()
    val arr = arrayOfNulls<Int>(6)
    /*fun lotto(){




        var i=0;
        while(i<=5) {
            Log.d("indexI", i.toString());
            arr[i] = random.nextInt(44) + 1
            var j = 0
            while (j < i && i != 0) {
                if (arr[j] == arr[i]) {
                    i--; break;
                }
                j++
            }
            i++
        }
        tv_main_act_num1.setText(arr[0].toString())
        tv_main_act_num2.setText(arr[1].toString())
        tv_main_act_num3.setText(arr[2].toString())
        tv_main_act_num4.setText(arr[3].toString())
        tv_main_act_num5.setText(arr[4].toString())
        tv_main_act_num6.setText(arr[5].toString())

    }*/





}


