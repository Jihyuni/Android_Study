package com.sopt.ch7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var pizzaCount = 0
        var spaghettiCount = 0
        var checked_pizza = false
        var checked_spaghetti = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState != null)
        {
            pizzaCount = savedInstanceState.getInt("PIZZA_COUNT")
            spaghettiCount = savedInstanceState.getInt("SPAGHETTI_COUNT")
            checked_pizza = savedInstanceState.getBoolean("PIZZA_STATUS")
            checked_spaghetti = savedInstanceState.getBoolean("SPAGHETTI_STATUS")

            tv_main_act_pizza_cnt.text =""+ pizzaCount
            tv_main_act_spaghetti_cnt.text = ""+spaghettiCount

        }




    }
    fun onCheckBoxClicked(view : View){
        val str = ""
        val checked = (view as CheckBox).isChecked

        when(view.id) {
            R.id.cb_main_act_pizza -> checked_pizza = checked
            R.id.cb_main_act_spaghetti-> checked_spaghetti = checked
        }

    }

    fun onCheckedPizza(view: View){
        if(checked_pizza){
            when(view.id)
            {
                R.id.btn_main_act_add_pizza -> pizzaCount++
                R.id.btn_main_act_cancle_pizza-> pizzaCount--
            }
            tv_main_act_pizza_cnt.text = "" + pizzaCount

        }
    }

    fun onCheckedSpaghetti(view: View){
        if(checked_spaghetti){
            when(view.id){
                R.id.btn_main_act_add_spaghetti-> spaghettiCount++
                R.id.btn_main_act_cancle_spaghetti-> spaghettiCount--

            }
            tv_main_act_spaghetti_cnt.text = ""+ spaghettiCount
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("PIZZA_COUNT", pizzaCount)
        outState?.putInt("SPAGHETTI_COUNT", spaghettiCount)
        outState?.putBoolean("PIZZA_STATUS", checked_pizza)
        outState?.putBoolean("SPAGHETTI_STATUS", checked_spaghetti)
    }

}
