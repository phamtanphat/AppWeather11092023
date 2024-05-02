package com.example.appweather11092023.helper

import com.example.appweather11092023.data.api.dto.temp_current.TempCurrentDTO
import com.example.appweather11092023.data.model.Weather
import com.example.appweather11092023.util.DateUtil

object WeatherHelper {

    fun parseFromTempCurrent(dto: TempCurrentDTO): Weather {
        return Weather(
            countryName = dto.sys.country,
            cityName = dto.name,
            temp = dto.main.temp,
            tempMin = dto.main.tempMin,
            tempMax = dto.main.tempMax,
            status = dto.weather.getOrNull(0)?.main ?: "",
            humidity = dto.main.humidity,
            cloud = dto.clouds.all,
            windSpeed = dto.wind.speed,
            timeUpdate = DateUtil.convertToDate(dto.dt)
        )
    }
}