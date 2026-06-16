package com.example.antokeberapps.Data.Dao

import androidx.room.*
import com.example.antokeberapps.Data.Entity.FavoriteNewsEntity

@Dao
interface FavoriteNewsDao {

    @Query("SELECT * FROM favorite_news")
    suspend fun getAll(): List<FavoriteNewsEntity>

    @Insert
    suspend fun insert(news: FavoriteNewsEntity)

    @Delete
    suspend fun delete(news: FavoriteNewsEntity)
}