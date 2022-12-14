package com.ludwikowski.hackillinois.hackillinoischallenge

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.hackillinois.org/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface EventApiService {
    @GET("event/")
    fun getEvents(): Call<HackIllinoisResponse>
}

object EventApi {
    val eventApi: EventApiService by lazy {
        retrofit.create(EventApiService::class.java)
    }
}