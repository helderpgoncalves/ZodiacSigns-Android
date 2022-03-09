package com.bitdev.birthdaycard

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import java.time.LocalDate
import java.time.Period
import java.util.*


class MainApp : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private lateinit var DateButt: Button
    private lateinit var Date: TextView
    private lateinit var name: EditText
    private lateinit var topanim: Animation
    private lateinit var bottomanim: Animation
    private lateinit var leftanim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main_app)
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        leftanim = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        name = findViewById(R.id.edit_name)
        DateButt = findViewById(R.id.date)
        Date = findViewById(R.id.textView)
        DateButt.animation = bottomanim
        name.animation = topanim
        Date.animation = topanim

        DateButt.setOnClickListener {
            val c: Calendar = Calendar.getInstance()
            val year: Int = c.get(Calendar.YEAR)
            val month: Int = c.get(Calendar.MONTH)
            val day: Int = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(this@MainApp, this@MainApp, year, month, day)
            datePickerDialog.show()
        }
    }

    fun getAge(year: Int, month: Int, dayOfMonth: Int): Int {
        return Period.between(
            LocalDate.of(year, month, dayOfMonth),
            LocalDate.now()
        ).years
    }

    fun getBirthstone(month: Int): String {
        if (month == 1) {
            return "Garnet"
        } else if (month == 2) {
            return "Amethyst"
        } else if (month == 3) {
            return "Aquamarine"
        } else if (month == 4) {
            return "Diamond"
        } else if (month == 5) {
            return "Emerald"
        } else if (month == 6) {
            return "Pearl"
        } else if (month == 7) {
            return "Ruby"
        } else if (month == 8) {
            return "Peridot"
        } else if (month == 9) {
            return "Sapphire"
        } else if (month == 10) {
            return "Opal"
        } else if (month == 11) {
            return "Topaz"
        } else {
            return "Turquoise"
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        if (name.text.toString() != "") {
            val my_zodiac = getZodiac(dayOfMonth, month)
            val age = getAge(year, month, dayOfMonth)
            val birthstone = getBirthstone(month)
            if (age >= 0) {
                intent = Intent(this@MainApp, EndActivity::class.java)
                intent!!.putExtra("Zodiac", my_zodiac)
                intent!!.putExtra("age", age.toString())
                intent!!.putExtra("birthstone", birthstone)
                intent!!.putExtra("name", name.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "You can't use future birt date!", Toast.LENGTH_LONG).show()
            }
        } else {
            // Make Simple Dialog
            val alertDialog: AlertDialog? = this.let {
                val builder = AlertDialog.Builder(it)
                builder.apply {
                    setPositiveButton("OK",
                        DialogInterface.OnClickListener { dialog, id ->
                            // User clicked OK button
                        })
                }
                builder.setMessage(R.string.enter_name_dialog)
                // Create the AlertDialog
                builder.create()
            }

            alertDialog!!.show()
        }
    }

    private fun getZodiac(day: Int, month: Int): String {
        var zodiacSign = ""
        if (month == 0) {
            zodiacSign = if (day < 20) {
                "Capricorn"
            } else {
                "Aquarius"
            }
        } else if (month == 1) {
            zodiacSign = if (day < 19) {
                "Aquarius"
            } else {
                "Pisces"
            }
        } else if (month == 2) {
            zodiacSign = if (day < 21) {
                "Pisces"
            } else {
                "Aries"
            }
        } else if (month == 3) {
            zodiacSign = if (day < 20) {
                "Aries"
            } else {
                "Taurus"
            }
        } else if (month == 4) {
            zodiacSign = if (day < 21) {
                "Taurus"
            } else {
                "Gemini"
            }
        } else if (month == 5) {
            zodiacSign = if (day < 22) {
                "Gemini"
            } else {
                "Cancer"
            }
        } else if (month == 6) {
            zodiacSign = if (day < 23) {
                "Cancer"
            } else {
                "Leo"
            }
        } else if (month == 7) {
            zodiacSign = if (day < 23) {
                "Leo"
            } else {
                "Virgo"
            }
        } else if (month == 8) {
            zodiacSign = if (day < 23) {
                "Virgo"
            } else {
                "Libra"
            }
        } else if (month == 9) {
            zodiacSign = if (day < 24) {
                "Libra"
            } else {
                "Scorpio"
            }
        } else if (month == 10) {
            zodiacSign = if (day < 23) {
                "Scorpio"
            } else {
                "Sagittarius"
            }
        } else if (month == 11) {
            zodiacSign = if (day < 22) {
                "Sagittarius"
            } else {
                "Capricorn"
            }
        }
        return zodiacSign
    }
}