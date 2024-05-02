package com.example.appweather11092023.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.appweather11092023.common.AppInterface
import com.example.appweather11092023.data.api.dto.temp_current.TempCurrentDTO
import com.example.appweather11092023.data.repository.WeatherRepository
import com.example.appweather11092023.helper.WeatherHelper

class MainViewModel: ViewModel() {
    private var weatherRepository = WeatherRepository()

    fun searchTempByCityName(cityName: String) {
        weatherRepository.requestTempByCityName(
            cityName = cityName,
            onListenResponse = object : AppInterface.OnListenResponse<TempCurrentDTO> {
                override fun onSuccess(data: TempCurrentDTO) {
                    val weather = WeatherHelper.parseFromTempCurrent(data)
                    Log.d("pphat", weather.toString())
                }

                override fun onFail(message: String) {
                    Log.d("pphat", message)
                }
            })
    }
}