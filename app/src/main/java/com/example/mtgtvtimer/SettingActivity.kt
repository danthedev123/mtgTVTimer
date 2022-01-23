package com.example.mtgtvtimer

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import android.widget.Button
import android.content.Intent


class SettingActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val _5minbutton: Button = findViewById(R.id.button5)


        val intent = Intent(this, MainActivity::class.java)


        _5minbutton.setOnClickListener {
            intent.putExtra("timeMinutes", 5)

            startActivity(intent)
        }
    }
}