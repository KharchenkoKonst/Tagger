package com.example.tagger.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "images")
data class Image(
    @PrimaryKey(autoGenerate = true) val imageId: Long,
    val imageURI: String
) : Parcelable
