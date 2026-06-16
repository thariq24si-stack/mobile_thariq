package com.example.antokeberapps.Data.Dao

import androidx.room.*
import com.example.antokeberapps.Data.Entity.NoteEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    suspend fun getAll(): List<NoteEntity>

    @Insert
    suspend fun insert(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)
}