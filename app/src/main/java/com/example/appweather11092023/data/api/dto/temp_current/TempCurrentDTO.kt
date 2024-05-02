package com.example.appweather11092023.data.api.dto.temp_current

import com.google.gson.annotations.SerializedName

data class TempCurrentDTO (
    val coord: CoordTempCurrentDTO,
    val weather: List<WeatherTempCurrentDTO>,
    val base: String,
    val main: MainTempCurrentDTO,
    val visibility: Long,
    val wind: WindTempCurrentDTO,
    val clouds: CloudsTempCurrentDTO,
    val dt: Long,
    val sys: SysTempCurrentDTO,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long,
)

data class CoordTempCurrentDTO(
    val lon: Double,
    val lat: Double,
)

data class WeatherTempCurrentDTO(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)

data class MainTempCurrentDTO(
    val temp: Float,
    @SerializedName("feels_like")
    val feelsLike: Float,
    @SerializedName("temp_min")
    val tempMin: Float,
    @SerializedName("temp_max")
    val tempMax: Float,
    val pressure: Float,
    val humidity: Float,
    @SerializedName("sea_level")
    val seaLevel: Float,
    @SerializedName("grnd_level")
    val grndLevel: Float,
)

data class WindTempCurrentDTO(
    val speed: Double,
    val deg: Long,
    val gust: Double,
)

data class CloudsTempCurrentDTO(
    val all: Long,
)

data class SysTempCurrentDTO(
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)
