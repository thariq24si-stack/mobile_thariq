package com.example.antokeberapps.Data.Api

import com.example.antokeberapps.Data.Model.BeritaModel
import retrofit2.http.GET

interface BeritaApiService {

    @GET("posts")
    suspend fun getBerita(): List<BeritaModel>

}