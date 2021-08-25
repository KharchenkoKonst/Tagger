package com.example.tagger.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "images")
data class TaggedImageEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val tags: List<String>,
    val imageURI: String
) : Parcelable
