package com.khusinov.reqresretrofit

import com.khusinov.reqresretrofit.data.CreateUser
import com.khusinov.reqresretrofit.data.SingleUser.SingleUserResponse
import com.khusinov.reqresretrofit.data.User
import com.khusinov.reqresretrofit.data.UserResponce
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("users")
    fun getUsersList(): Call<UserResponce>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Call<SingleUserResponse>

    @POST("users")
    fun createUser(@Body user: User): Call<CreateUser>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id:Int):Call<Unit>
}