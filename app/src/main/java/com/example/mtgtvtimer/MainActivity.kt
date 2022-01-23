package com.example.mtgtvtimer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.view.View
import androidx.fragment.app.FragmentActivity
import java.util.concurrent.TimeUnit
import java.math.BigInteger

/**
 * Loads [MainFragment].
 *
*/

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value: Int = intent.extras!!.getInt("timeMinutes")

        val millis = value * 1000 * 60

        val button: Button = findViewById(R.id.button3)

        val stopButton: Button = findViewById(R.id.stopbtn)

        val textview1: TextView = findViewById(R.id.textView)

        button.text = "Start timer"

        textview1.text = "Millis = $millis"

        val timer: CountDownTimer = object : CountDownTimer(millis.toLong(), 1000) {

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

                button.visibility = View.VISIBLE;
                stopButton.visibility = View.GONE;
            }
        }

        stopButton.setOnClickListener {
            stopButton.visibility = View.GONE;
            button.visibility = View.VISIBLE;

            timer.cancel()

            textview1.text = "Done!"
        }


        button.setOnClickListener {
            button.visibility = View.GONE;
            stopButton.visibility = View.VISIBLE;


            timer.start()
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}