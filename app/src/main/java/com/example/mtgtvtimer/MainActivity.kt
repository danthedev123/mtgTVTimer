package com.example.mtgtvtimer

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import java.util.concurrent.TimeUnit

/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button3)

        val textview1: TextView = findViewById(R.id.textView)

        button.text = "Start timer"

        textview1.text = "Hello from Kotlin"


        button.setOnClickListener {
            object : CountDownTimer(30000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    textview1.text = "Time remaining: " + String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
                }

                override fun onFinish() {
                    textview1.text = "Done!"
                }
            }.start()
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}