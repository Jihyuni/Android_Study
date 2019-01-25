package com.sopt.ch7_2

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   // private val items : Array<CharSequence> = arrayOf("Red","Green","Blue")
    //private val DIALOG_MESSAGE= 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ㄹㅣ소스 참조 하려면 리소스 생성 끝난 뒤에 해야함

        val items :Array<String> = resources.getStringArray(R.array.colors)

        var mSelect = 0


       // btn_main_act_call.setOnClickListener{
       //     createDialog(DIALOG_MESSAGE)?.show()
       // }

        btn_main_act_call.setOnClickListener {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Messager Board")
           /* builder.setItems(items){
                dialog, which ->
                Toast.makeText(applicationContext,"${items[which]} selected",Toast.LENGTH_SHORT).show()
            }*/
            builder.setSingleChoiceItems(items ,mSelect){
                        dialog, which ->  mSelect = which
                    }
            //builder.setMessage("Open the dialog")
            //setItems와 setMessage 같이 오면 setMessage 작동함

            //builder.setIcon(R.drawable.ic_launcher_foreground)
            builder.setPositiveButton("yes"){
                dialog, which ->  Toast.makeText(applicationContext,"${items[mSelect]} selected",Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("cancel",null)

            builder.show()
        }

    }

    /*protected fun crateDialog(id : Int) :Dialog?{
        var alert : Dialog? = null

        when(id){
            DIALOG_MESSAGE->{
                val builder = AlertDialog.Builder(this)
                builder
                        .setTitle("Simple Question")
                        .setMessage("Are you sure tht you want to quit?")
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setPositiveButton("yes"){dialog, which -> finish() }
                        .setNegativeButton("no"){
                            dialog, which ->
                            Toast.makeText(applicationContext,"operation is cancelled",Toast.LENGTH_LONG).show() }
                        .setNeutralButton("cancel",null)
                alert = builder.create()
            }

        }
        return alert
    }*/
}
