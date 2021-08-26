package com.example.tagger.data.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ImageWithTags(
    @Embedded val imageEntity: ImageEntity,
    @Relation(
        parentColumn = "imageId",
        entityColumn = "tagId",
        associateBy = Junction(TagImageAssociation::class)
    )
    val tags: List<TagEntity>
)