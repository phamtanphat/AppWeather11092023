package com.example.appweather11092023.util

import java.util.Date

object DateUtil {

    fun convertToDate(seconds: Long): Date {
        return Date(seconds * 1000)
    }
}