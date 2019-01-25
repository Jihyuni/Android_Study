package com.sopt.seminar_05

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_sub.*
import org.jetbrains.anko.toast

class SubActivity : AppCompatActivity() {

    val bottomBarAnimaition : Animation by lazy {
        AnimationUtils.loadAnimation(this,R.anim.example_animation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        bottomBarAnimaition.setAnimationListener(object : Animation.AnimationListener
        {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                toast("애니메이션 끝!")
            }

            override fun onAnimationStart(animation: Animation?) {

            }

        })

        btn_sub_act_show_bottom_bar.setOnClickListener{
            rl_sub_act_bottom_bar.visibility = View.VISIBLE
          rl_sub_act_bottom_bar.startAnimation(bottomBarAnimaition)
        }

    }


}
