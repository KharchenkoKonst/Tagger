package com.example.tagger.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.example.tagger.data.entities.*

@Dao
interface Dao {
    @Transaction
    @Query("SELECT * FROM tag WHERE tagContent = :tag")
    suspend fun getByTag(tag: String): TagWithImages

    @Transaction
    @Query("SELECT * FROM image WHERE imageURI = :uri")
    suspend fun getByImage(uri: String): ImageWithTags

    @Query("SELECT * FROM TagImageAssociation WHERE tagId = :tagId AND imageId = :imageId")
    suspend fun getAssociation(tagId: Long, imageId: Long): TagImageAssociation

    @Query("DELETE FROM TagImageAssociation WHERE tagId = :tagId AND imageId = :imageId")
    suspend fun removeAssociation(tagId: Long, imageId: Long): TagImageAssociation

    @Insert(onConflict = REPLACE)
    suspend fun insert(tagImageAssociation: TagImageAssociation): Long

    @Insert(onConflict = REPLACE)
    suspend fun insert(imageEntity: ImageEntity): Long

    @Insert(onConflict = REPLACE)
    suspend fun insert(tagEntity: TagEntity): Long


//    @Transaction
//    @Query("SELECT * FROM tag WHERE tagContent = :tag")
//    fun getById(tag: String): List<TagImageAssotiation>
//
//    @Transaction
//    @Insert
//    suspend fun insert(tagImageAssotiation: TagImageAssotiation)

//    @Query("SELECT * FROM images")
//    fun getAll(tags: List<String>): LiveData<TaggedImageEntity>
//
//    @Insert
//    suspend fun insert(taggedImageEntity: TaggedImageEntity)
//
//    @Update
//    suspend fun update(taggedImageEntity: TaggedImageEntity)
//
//    @Delete
//    suspend fun delete(taggedImageEntity: TaggedImageEntity)
}
