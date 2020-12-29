package com.example.applicationkotlin.domain.services

import com.example.applicationkotlin.domain.entity.Character
import retrofit2.Call
import retrofit2.http.GET

interface HpService {

    @GET("characters")
    fun getCharacters() : Call<List<Character>>
}