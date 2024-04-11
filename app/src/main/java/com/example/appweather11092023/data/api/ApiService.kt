package com.example.appweather11092023.data.api

import com.example.appweather11092023.data.api.dto.temp_current.TempCurrentDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // get weather from search location
    @GET("data/2.5/weather?")
    fun getTempByCityName(
        @Query("appid") appID: String,
        @Query("units") units: String,
        @Query("q") q: String
    ): Call<TempCurrentDTO>
}