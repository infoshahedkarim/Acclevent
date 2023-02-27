package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    val SPLASH_SCREENs = 4000

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    private lateinit var imageView: ImageView
    private lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_main)
        topAnimation= AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation= AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        imageView= findViewById(R.id.acce)
        lottieAnimationView= findViewById(R.id.bgAnim)


        lottieAnimationView.animation= topAnimation
        imageView.animation =bottomAnimation


        Handler().postDelayed({

            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREENs.toLong())


    }
}