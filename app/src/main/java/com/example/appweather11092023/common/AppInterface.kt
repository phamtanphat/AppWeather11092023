package com.example.appweather11092023.common

object AppInterface {

    interface OnListenResponse {
        fun<T> onSuccess(data: T)
        fun onFail(message: String)
    }
}