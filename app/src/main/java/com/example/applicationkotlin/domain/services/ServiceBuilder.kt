package com.example.applicationkotlin.domain.services

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val gsonInstance : Gson
    get() {
        TODO()
    }

object ServiceBuilder {
    private const val URL = "http://hp-api.herokuapp.com/api/"

    private val okHttp = OkHttpClient.Builder()

    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun<T> buildService(serviceType : Class<T>): T {
        return retrofit.create(serviceType)
    }

    fun getGson() : Gson {
        if(gsonInstance == TODO()) {
            gsonInstance = GsonBuilder()
                .setLenient()
                .create();
        }
        return gsonInstance;
    }

}