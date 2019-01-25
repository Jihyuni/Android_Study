package com.sopt.ch7_2

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import android.widget.ViewAnimator
import kotlinx.android.synthetic.main.activity_date_picker.*
import kotlinx.android.synthetic.main.activity_dialog.*
import java.util.*

class DialogActivity : AppCompatActivity() {

    val DATE_DIALOG_ID = 0
    val TIME_DIALOG_ID = 1

    val c = GregorianCalendar()
    var mYear = c.get(Calendar.YEAR)
    var mMonth = c.get(Calendar.MONTH)
    var mDay = c.get(Calendar.DAY_OF_MONTH)
    var mHour = c.get(Calendar.HOUR_OF_DAY)
    var mMinute = c.get(Calendar.MINUTE)
    //현재의 날짜,시간으로 초기화

    var selectedDate: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)



        btn_dialog_act_datepicker.setOnClickListener(){
            date_picker.visibility=View.VISIBLE
        }




            val dateChangeListener = DatePicker.OnDateChangedListener{
                view, year, monthOfYear, dayOfMonth ->
                tv_select_date.text = String.format(
                    Locale.KOREA,"%d-%d-%d",
                    year,monthOfYear+1,dayOfMonth
            )
            }

            date_picker.init(
                    date_picker.year,
                    date_picker.month,
                    date_picker.dayOfMonth,
                    dateChangeListener)







        }



    }


