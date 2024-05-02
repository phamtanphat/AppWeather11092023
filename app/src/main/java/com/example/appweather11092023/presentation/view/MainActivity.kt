package com.example.appweather11092023.presentation.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appweather11092023.R
import com.example.appweather11092023.common.AppInterface
import com.example.appweather11092023.data.repository.WeatherRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val weatherRepo = WeatherRepository()
        weatherRepo.requestTempByCityName("Ha Nwqewqeoi", object : AppInterface.OnListenResponse {
            override fun <T> onSuccess(data: T) {

            }

            override fun onFail(message: String) {

            }

        })
    }
}