package com.example.tagger.data

import android.content.Context
import com.example.tagger.data.database.AppDatabase
import com.example.tagger.data.entities.ImageEntity
import com.example.tagger.data.entities.TagEntity
import com.example.tagger.data.entities.TagImageAssociation
import com.example.tagger.data.entities.TagWithImages
import com.example.tagger.domain.models.Image
import com.example.tagger.domain.models.Tag
import com.example.tagger.domain.repository.ImagesRepository

class ImagesRepositoryImpl(context: Context) : ImagesRepository {
    private val dao = AppDatabase.getDatabase(context).dao()
    override suspend fun add(tag: Tag, images: List<Image>) {

    }

    override suspend fun getByTag(tag: Tag): List<Image> {
        TODO("Not yet implemented")
    }

}