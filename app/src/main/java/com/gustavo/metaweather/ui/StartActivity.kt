package com.gustavo.metaweather.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gustavo.locationweather.ui.WeatherActivity
import com.gustavo.metaweather.R

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        startActivity(Intent(this, WeatherActivity::class.java))
        finish()
    }
}