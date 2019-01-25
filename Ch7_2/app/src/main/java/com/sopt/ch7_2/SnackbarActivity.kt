package com.sopt.ch7_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_snackbar.*
import java.time.Duration
import java.util.*

class SnackbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        btn_snackbar_act.setOnClickListener {
            val view = findViewById<View>(R.id.lo_snackbar_act)
            var message = "Snackbar message"
            var duration = Snackbar.LENGTH_SHORT


            showSnackbar(view, message, duration)
        }

    }


        fun showSnackbar(view: View, message: String, duration: Int) {
            //Snackbar.make(view, message, duration).show()
            val snackbar = Snackbar.make(view,message,duration)

            snackbar.setAction("DISMISS"){
                snackbar.dismiss()
            }

            snackbar.show()
        }

}
