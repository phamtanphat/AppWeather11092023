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
import org.json.JSONObject
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
                    if (response.errorBody() != null) {
                        try {
                            val errorBodyString = response.errorBody()?.string() ?: "{}"
                            val jsonError = JSONObject(errorBodyString)
                            val message = jsonError.getString("message")
                            onListenResponse.onFail(message)
                        } catch (_: Exception) { }
                    } else {
                        onListenResponse.onSuccess(response.body())
                    }
                }

                override fun onFailure(call: Call<TempCurrentDTO>, t: Throwable) {
                    onListenResponse.onFail(t.message.toString())
                }
            })
        }
    }
}