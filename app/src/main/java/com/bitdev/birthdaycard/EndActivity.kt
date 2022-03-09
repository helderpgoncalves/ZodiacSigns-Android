package com.bitdev.birthdaycard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class EndActivity : AppCompatActivity() {
    private lateinit var zodiac_text: TextView
    private lateinit var age_text: TextView
    private lateinit var zodiac_text2: TextView
    private lateinit var birthStoneText : TextView
    private lateinit var name: TextView
    private lateinit var topanim: Animation
    private lateinit var bottomanim: Animation
    private lateinit var leftanim: Animation
    private lateinit var back: Button
    var zodiac: String? = null
    var age: String? = null
    var birthstone : String? = null
    private lateinit var zodiac_sign: ImageView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_end)
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        leftanim = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        val intent = intent
        name = findViewById(R.id.text_name)
        name.text = intent.getStringExtra("name")

        age_text = findViewById(R.id.age)
        age = intent.getStringExtra("age")
        age_text.text = age + "y"

        birthStoneText = findViewById(R.id.birthstone)
        birthstone = intent.getStringExtra("birthstone")
        birthStoneText.text = "Birthstone: $birthstone"

        zodiac = intent.getStringExtra("Zodiac")
        zodiac_text = findViewById(R.id.textView)
        zodiac_text2 = findViewById(R.id.textView1)
        zodiac_sign = findViewById(R.id.imageView2)
        back = findViewById(R.id.button)
        back.setOnClickListener {
            val i = Intent(this@EndActivity, MainApp::class.java)
            startActivity(i)
        }

        zodiac_text.setText(R.string.Aquarius)
        if (zodiac == "Capricorn") {
            zodiac_sign.setImageResource(R.drawable.capricorn)
            zodiac_text.text = zodiac
            zodiac_text2.setText(R.string.Capricorn)
        } else if (zodiac == "Aquarius") {
            zodiac_sign.setImageResource(R.drawable.aquarius)
            zodiac_text.text = zodiac
            zodiac_text2.setText(R.string.Aquarius)
        } else if (zodiac == "Pisces") {
            zodiac_sign.setImageResource(R.drawable.pisces)
            zodiac_text2.setText(R.string.Pisces)
            zodiac_text.text = zodiac
        } else if (zodiac == "Aries") {
            zodiac_sign.setImageResource(R.drawable.aries)
            zodiac_text2.setText(R.string.Aries)
            zodiac_text.text = zodiac
        } else if (zodiac == "Taurus") {
            zodiac_sign.setImageResource(R.drawable.taurus)
            zodiac_text2.setText(R.string.Taurus)
            zodiac_text.text = zodiac
        } else if (zodiac == "Gemini") {
            zodiac_sign.setImageResource(R.drawable.gemini)
            zodiac_text2.setText(R.string.Gemini)
            zodiac_text.text = zodiac
        } else if (zodiac == "Cancer") {
            zodiac_sign.setImageResource(R.drawable.cancer)
            zodiac_text2.setText(R.string.Cancer)
            zodiac_text.text = zodiac
        } else if (zodiac == "Leo") {
            zodiac_sign.setImageResource(R.drawable.leo)
            zodiac_text2.setText(R.string.Leo)
            zodiac_text.text = zodiac
        } else if (zodiac == "Virgo") {
            zodiac_sign.setImageResource(R.drawable.virgo)
            zodiac_text2.setText(R.string.Virgo)
            zodiac_text.text = zodiac
        } else if (zodiac == "Scorpio") {
            zodiac_sign.setImageResource(R.drawable.scorpio)
            zodiac_text2.setText(R.string.Scorpio)
            zodiac_text.text = zodiac
        } else if (zodiac == "Libra") {
            zodiac_sign.setImageResource(R.drawable.libra)
            zodiac_text2.setText(R.string.Libra)
            zodiac_text.text = zodiac
        } else if (zodiac == "Sagittarius") {
            zodiac_sign.setImageResource(R.drawable.sagittarius)
            zodiac_text2.setText(R.string.Sagittarius)
            zodiac_text.text = zodiac
        }
        zodiac_text2.animation = bottomanim
        zodiac_text.animation = bottomanim
        birthStoneText.animation = bottomanim
        zodiac_sign.animation = topanim
        name.animation = topanim
        age_text.animation = topanim
        back.animation = leftanim
    }
}