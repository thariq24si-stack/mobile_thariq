package com.example.antokeberapps.Data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_news")
data class FavoriteNewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String
)