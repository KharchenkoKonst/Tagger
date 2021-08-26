package com.example.tagger.data.entities

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tag")
data class TagEntity(
    @PrimaryKey(autoGenerate = true)
    val tagId: Long = 0,
    val tagContent: String,
//    TODO val tagPriority: Int
)
