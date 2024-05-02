package com.example.appweather11092023.data.repository

import android.util.Log
import com.example.appweather11092023.common.AppCommon
import com.example.appweather11092023.common.AppInterface
import com.example.appweather11092023.data.api.RetrofitClient
import com.example.appweather11092023.data.api.dto.temp_current.TempCurrentDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class WeatherRepository {
    private val apiService = RetrofitClient.getApiService()

    fun requestTempByCityName(cityName: String, onListenResponse: AppInterface.OnListenResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            apiService.getTempByCityName(
                appID = AppCommon.APP_ID,
                units = AppCommon.UNITS,
                q = cityName
            ).enqueue(object : Callback<TempCurrentDTO> {
                override fun onResponse(
                    call: Call<TempCurrentDTO>,
                    response: Response<TempCurrentDTO>
                ) {
                    Log.d("pphat", response.body().toString())
                }

                override fun onFailure(call: Call<TempCurrentDTO>, t: Throwable) {
                    Log.d("pphat", t.message.toString())
                }
            })
        }
    }
}