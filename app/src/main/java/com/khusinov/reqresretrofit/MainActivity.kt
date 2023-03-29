package com.khusinov.reqresretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.khusinov.reqresretrofit.data.CreateUser
import com.khusinov.reqresretrofit.data.User
import com.khusinov.reqresretrofit.data.UserResponce
import com.khusinov.reqresretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var retrofitService: RetrofitService
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitService = Common.retrofitServices

        retrofitService.getUsersList().enqueue(object : Callback<UserResponce> {
            override fun onResponse(call: Call<UserResponce>, response: Response<UserResponce>) {
                if (response.isSuccessful) {
                    Log.d(TAG, "onResponse: ${response.body().toString()} ")
                }
            }

            override fun onFailure(call: Call<UserResponce>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message.toString()}")
            }

        })

        val user = User("Shaxriyor", "Android dev")

        retrofitService.createUser(user).enqueue(object : Callback<CreateUser> {
            override fun onResponse(call: Call<CreateUser>, response: Response<CreateUser>) {
                if (response.isSuccessful) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<CreateUser>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message.toString()}")
            }

        })



    }
}