package com.example.tagger.data.entities

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Entity(primaryKeys = ["imageId", "tagId"])
data class ImageTagCrossRef(
    val imageId: Long,
    val tagId: Long
)

data class TagWithImages(
    @Embedded val tag:Tag,
    @Relation(
        parentColumn = "tagId",
        entityColumn = ""
    )
)

@Parcelize
@Entity(tableName = "tag")
data class Tag(
    @PrimaryKey(autoGenerate = true) val tagId: Long,
    val tag: String

) : Parcelable

