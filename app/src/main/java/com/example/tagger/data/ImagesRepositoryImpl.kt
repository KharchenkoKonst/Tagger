package com.example.tagger.data

import android.content.Context
import com.example.tagger.data.database.AppDatabase
import com.example.tagger.domain.models.Image
import com.example.tagger.domain.models.Tag
import com.example.tagger.domain.repository.ImagesRepository

class ImagesRepositoryImpl(context: Context) : ImagesRepository {
    private val dao = AppDatabase.getDatabase(context).dao()

    override suspend fun add(tag: Tag, images: List<Image>) {

        for (image in images) {
//            dao.add(tag.content, image.uri)
        }

//        val tagEntity = tag.toTagEntity()
//        val imageEntities = mutableListOf<ImageEntity>()
//        for (image in images) {
//            imageEntities.add(image.toImageEntity())
//        }
//
//        val tagWithImages =
//            TagWithImages(tagEntity, imageEntities)


//        suspend fun initIDs(
//            tags: List<Tag>,
//            images: List<Image>
//        ): Pair<List<TagEntity>, List<ImageEntity>> {
//            for (tag in tags){
//
//            }
//            val tagId = when (val query = dao.getTagByContent(tag.content)) {
//                null -> {
//                    dao.insert(TagEntity(tagContent = tag.content))
//                }
//                else -> {
//                    query.tagId
//                }
//            }
//        }

        /*
        check for tag existence
         */
//        val tagId = when (val query = dao.getTagByContent(tag.content)) {
//            null -> {
//                dao.insert(TagEntity(tagContent = tag.content))
//            }
//            else -> {
//                query.tagId
//            }
//        }
//
//        val tagImageAssociations = mutableListOf<TagImageAssociation>()
//
//        val imageIDs = mutableListOf<Long>()
//        for (image in images) {
//            imageIDs.add(dao.insert(ImageEntity(imageURI = image.uri)))
//            tagImageAssociations.add(TagImageAssociation(tagId, imageIDs.last()))
//        }
//        for (associationItem in tagImageAssociations) {
//            dao.insert(associationItem)
//        }
    }

    override suspend fun getByTag(tag: Tag): List<Image> {
        TODO("Not yet implemented")
    }

}