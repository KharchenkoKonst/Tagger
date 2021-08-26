package com.example.tagger.domain.repository

import com.example.tagger.domain.models.Image
import com.example.tagger.domain.models.Tag

interface ImagesRepository {
    suspend fun add(tag: Tag, images: List<Image>)
    suspend fun getByTag(tag: Tag): List<Image>
}