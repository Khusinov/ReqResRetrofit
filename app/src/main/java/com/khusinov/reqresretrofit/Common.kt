package com.khusinov.reqresretrofit


object Common {
    private val BASE_URL = "https://reqres.in/api/"
    val retrofitServices: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}