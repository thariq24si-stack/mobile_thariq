package com.example.antokeberapps.Data.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BeritaApiClient {

    private const val BASE_URL =
        "https://jsonplaceholder.typicode.com/"

    val apiService: BeritaApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(BeritaApiService::class.java)
    }
}