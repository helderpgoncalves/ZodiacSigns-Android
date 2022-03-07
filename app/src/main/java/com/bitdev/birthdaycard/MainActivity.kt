package com.bitdev.birthdaycard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var topanim: Animation? = null
    var bottomanim: Animation? = null
    var welcome: TextView? = null
    var zodiac: TextView? = null
    private val SPLASH = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        welcome = findViewById(R.id.welcome)
        zodiac = findViewById(R.id.zodiac)

        welcome!!.animation = bottomanim
        zodiac!!.animation = bottomanim

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, MainApp::class.java)
            startActivity(intent)
        }, SPLASH.toLong())
    }
}