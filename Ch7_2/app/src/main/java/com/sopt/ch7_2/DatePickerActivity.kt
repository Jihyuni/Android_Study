package com.sopt.ch7_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_date_picker.*
import java.util.*

class DatePickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        val dateChangeListener = DatePicker.OnDateChangedListener{
            view, year, monthOfYear, dayOfMonth ->  tv_datepicker_act.text = String.format(
                Locale.KOREA,"%d-%d-%d",
                year,monthOfYear+1,dayOfMonth
        )
        }

        datePicker_datepicker_act.init(
                datePicker_datepicker_act.year,
                datePicker_datepicker_act.month,
                datePicker_datepicker_act.dayOfMonth,
                dateChangeListener

        )
    }
}
