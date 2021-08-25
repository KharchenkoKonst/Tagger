package com.example.tagger.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.tagger.data.entities.TaggedImageEntity

@Dao
interface Dao {
    @Query("SELECT * FROM images WHERE id = :id")
    fun getById(id: Long): LiveData<TaggedImageEntity>

    @Query("SELECT * FROM images WHERE tags = :tags")
    fun getByTags(tags: List<String>): LiveData<TaggedImageEntity>

    @Insert
    suspend fun insert(taggedImageEntity: TaggedImageEntity)

    @Update
    suspend fun update(taggedImageEntity: TaggedImageEntity)

    @Delete
    suspend fun delete(taggedImageEntity: TaggedImageEntity)
}