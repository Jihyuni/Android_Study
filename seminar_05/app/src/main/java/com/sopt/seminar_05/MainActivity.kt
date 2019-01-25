package com.sopt.seminar_05

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val star_badge_animation : LottieAnimationView = findViewById(R.id.lottie_main_act_star)

        lottie_main_act_star.setOnClickListener { star_badge_animation.playAnimation()
        }

        star_badge_animation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
                Log.e("Animation:","repeat")
            }
            override fun onAnimationEnd(animation: Animator?) {
                Toast.makeText(application, "끝~",Toast.LENGTH_SHORT).show()
            }
            override fun onAnimationCancel(animation: Animator?) {
                Log.e("Animation:","cancel")
            }
            override fun onAnimationStart(animation: Animator?) {
                Log.e("Animation:","start")
            } })
    } }