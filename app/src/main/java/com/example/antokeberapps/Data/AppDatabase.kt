package com.example.antokeberapps.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.antokeberapps.Data.Dao.FavoriteNewsDao
import com.example.antokeberapps.Data.Dao.NoteDao
import com.example.antokeberapps.Data.Entity.FavoriteNewsEntity
import com.example.antokeberapps.Data.Entity.NoteEntity

@Database(
    entities = [
        NoteEntity::class,
        FavoriteNewsEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    abstract fun favoriteNewsDao(): FavoriteNewsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}