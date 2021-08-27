package com.example.tagger.data.entities

import androidx.room.Entity

@Entity(primaryKeys = ["tag", "image"])
data class TagImageEntity(
    val tag: String,
    val image: String
)