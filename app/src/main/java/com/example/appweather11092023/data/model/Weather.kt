package com.example.appweather11092023.data.model

import java.util.Date

data class Weather (
    var countryName: String? = "",
    var cityName: String? = "",
    var temp: Float? = 0.0f,
    var tempMin: Float? = 0.0f,
    var tempMax: Float? = 0.0f,
    var status: String? = "",
    var humidity: Float? = 0.0f,
    var cloud: Int? = 0,
    var windSpeed: Float? = 0.0f,
    var timeUpdate: Date? = null
)