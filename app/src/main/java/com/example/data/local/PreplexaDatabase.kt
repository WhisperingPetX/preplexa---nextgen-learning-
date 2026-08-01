package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TestAttemptEntity::class, BookmarkedQuestionEntity::class, CustomQuestionEntity::class],
    version = 2,
    exportSchema = false
)
abstract class PreplexaDatabase : RoomDatabase() {
    abstract fun preplexaDao(): PreplexaDao

    companion object {
        @Volatile
        private var INSTANCE: PreplexaDatabase? = null

        fun getDatabase(context: Context): PreplexaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PreplexaDatabase::class.java,
                    "preplexa_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
