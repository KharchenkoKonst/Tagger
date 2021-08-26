package com.example.tagger.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.tagger.data.database.AppDatabase
import com.example.tagger.data.database.Dao
import com.example.tagger.data.entities.ImageEntity
import com.example.tagger.data.entities.TagEntity
import com.example.tagger.data.entities.TagImageAssociation
import com.example.tagger.data.entities.TagWithImages
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ImagesRepositoryImplTest {

    private lateinit var db: AppDatabase
    private lateinit var dao: Dao

    @BeforeAll
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.dao()
    }

    @AfterAll
    fun tearDown() {
        db.close()
    }

    @Test
    @Disabled
    fun createData(): Unit = runBlocking {

        val tagsContent = listOf("tag1", "tag2", "tag3")
        val tagIDs = mutableListOf<Long>()

        for (tagContent in tagsContent) {
            tagIDs.add(dao.insert(TagEntity(tagContent = tagContent)))
        }

        val imagesUri = listOf("uri1", "uri2", "uri3")
        val imageIDs = mutableListOf<Long>()

        for (imageUri in imagesUri) {
            imageIDs.add(dao.insert(ImageEntity(imageURI = imageUri)))
        }

        val tableAssociation = listOf<TagImageAssociation>(
            TagImageAssociation(tagIDs[0], imageIDs[0]),
            TagImageAssociation(tagIDs[0], imageIDs[1]),
            TagImageAssociation(tagIDs[1], imageIDs[1]),
            TagImageAssociation(tagIDs[1], imageIDs[2]),
        )

        for (association in tableAssociation) {
            dao.insert(association)
        }

        val result = mutableListOf<TagWithImages>()
        result.add(dao.getByTag("tag1"))
        result.add(dao.getByTag("tag2"))
        result.add(dao.getByTag("tag3"))

        Assertions.assertEquals(result[0].images[0].imageURI, "uri1")
        Assertions.assertEquals(result[0].images[1].imageURI, "uri2")
        Assertions.assertEquals(result[1].images[0].imageURI, "uri2")
        Assertions.assertEquals(result[1].images[1].imageURI, "uri3")
        Assertions.assertEquals(result[2].images.size, 0)
    }

    @Test
    fun editData(): Unit = runBlocking {
        createData()

        val imageForEdit = dao.getByImage("uri2")
        val newTag = "tag3"
        val oldTag = "tag1"

        //Замена тегом, существующим в БД
        val existInBdTag = dao.getByTag("tag3")


        //Вывод существующих тегов
        val currentTags = mutableListOf<TagEntity>()
        val tagToImageAssociations = mutableListOf<TagImageAssociation>()
        for (tag in imageForEdit.tags) {
            tagToImageAssociations.add(TagImageAssociation(tag.tagId, imageForEdit.imageEntity.imageId))
        }



        val requiresExistTag = dao.getByTag("tag1")
        val requiresNotExistTag = dao.getByTag("newTag")
        val tagForReplace = imageForEdit.tags[0].tagId

        dao.removeAssociation(imageForEdit.tags[0].tagId, imageForEdit.imageEntity.imageId)
        dao.insert(TagImageAssociation(requiresExistTag.tagEntity.tagId, imageForEdit.imageEntity.imageId))

        dao.removeAssociation(imageForEdit.tags[1].tagId, imageForEdit.imageEntity.imageId)

    }
}