package com.example.prak15_16_romanov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LadingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lading_screen)

        val timer= object : CountDownTimer(5000,1000)
        {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                val intent= Intent(this@LadingScreen,RegisterScreen::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}