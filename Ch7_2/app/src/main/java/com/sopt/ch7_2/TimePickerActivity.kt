package com.sopt.ch7_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_time_picker.*
import java.util.*

class TimePickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        timePicker.setOnTimeChangedListener{
            view, hourOfDay, minute ->  tv_timepicker_act.text = String.format(
                Locale.KOREA,
                "%d:%d",hourOfDay,minute
        )
        }

        btn_timepicker_act_toggle.setOnClickListener{
            timePicker.setIs24HourView(
                    !timePicker.is24HourView
            )
        }


    }
}
