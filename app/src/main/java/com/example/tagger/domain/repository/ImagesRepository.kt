package com.example.tagger.domain.repository

import com.example.tagger.domain.models.TaggedImage

interface ImagesRepository {
    suspend fun add(taggedImage: TaggedImage)
    suspend fun edit(taggedImage: TaggedImage)
    suspend fun remove(taggedImage: TaggedImage)
}