package com.example.tagger.data.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TagWithImages(
    @Embedded val tagEntity: TagEntity,
    @Relation(
        parentColumn = "tagId",
        entityColumn = "imageId",
        associateBy = Junction(TagImageAssociation::class)
    )
    val images: List<ImageEntity>
)