package com.example.tagger.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tagger.data.entities.TagImageEntity

@Database(
//    entities = [ImageEntity::class, TagEntity::class, TagImageAssociation::class],
    entities = [TagImageEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}