package com.gustavo.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gustavo.locationweather.ui.WeatherActivity

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        startActivity(Intent(this, WeatherActivity::class.java))
        finish()
    }
}