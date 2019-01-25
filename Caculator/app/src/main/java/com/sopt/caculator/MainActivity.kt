package com.sopt.caculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val ADD =1
    val SUB =2
    val MULT=3
    val DEV=4
    var status :Int = 0

    var list : ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_main_act_0.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"0")
            list.add("0")
        }
        btn_main_act_1.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"1")
            list.add("1")
        }
        btn_main_act_2.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"2")
            list.add("2")
        }
        btn_main_act_3.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"3")
            list.add("3")}
        btn_main_act_4.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"4")
            list.add("4")}
        btn_main_act_5.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"5")
            list.add("5")}
        btn_main_act_6.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"6")
            list.add("6")}
        btn_main_act_7.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"7")
            list.add("7")}
        btn_main_act_8.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"8")
            list.add("8")}
        btn_main_act_9.setOnClickListener{
            if(list.isEmpty())
            {
                et_main_act_result.setText("")
            }
            et_main_act_result.setText(et_main_act_result.text.toString()+"9")
            list.add("9")}
        btn_main_act_add.setOnClickListener{
            et_main_act_result.setText(et_main_act_result.text.toString()+"+")
            status = ADD
        }
        btn_main_act_sub.setOnClickListener{
            et_main_act_result.setText(et_main_act_result.text.toString()+"-")
            status = SUB
        }
        btn_main_act_mult.setOnClickListener{
            et_main_act_result.setText(et_main_act_result.text.toString()+"*")
            status = MULT
        }
        btn_main_act_dev.setOnClickListener{
            et_main_act_result.setText(et_main_act_result.text.toString()+"/")
            status = DEV
        }
        btn_main_act_clear.setOnClickListener{
            et_main_act_result.setText("0")
            list.clear()}

        btn_main_act_result.setOnClickListener{
            et_main_act_result.setText("")
            calculation(status)}

    }


    fun calculation(status:Int){

        var result= 0
        
        when(status){

            ADD->
                result = list.get(0).toInt() + list.get(1).toInt()
            SUB->
                result = list.get(0).toInt() - list.get(1).toInt()
            MULT->
                result = list.get(0).toInt() * list.get(1).toInt()
            DEV->
                result = list.get(0).toInt() / list.get(1).toInt()
        }
        et_main_act_result.setText(result.toString())

    }
}
