package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PreplexaDao {
    @Query("SELECT * FROM test_attempts ORDER BY timestamp DESC")
    fun getAllTestAttempts(): Flow<List<TestAttemptEntity>>

    @Query("SELECT * FROM test_attempts WHERE topicId = :topicId ORDER BY timestamp DESC")
    fun getAttemptsForTopic(topicId: String): Flow<List<TestAttemptEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttempt(attempt: TestAttemptEntity)

    @Query("SELECT * FROM bookmarked_questions ORDER BY timestamp DESC")
    fun getAllBookmarks(): Flow<List<BookmarkedQuestionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bookmarkQuestion(question: BookmarkedQuestionEntity)

    @Query("DELETE FROM bookmarked_questions WHERE questionId = :questionId")
    suspend fun removeBookmark(questionId: String)

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarked_questions WHERE questionId = :questionId)")
    fun isQuestionBookmarked(questionId: String): Flow<Boolean>

    @Query("SELECT * FROM custom_questions ORDER BY timestamp DESC")
    fun getAllCustomQuestions(): Flow<List<CustomQuestionEntity>>

    @Query("SELECT * FROM custom_questions WHERE category = :category ORDER BY timestamp DESC")
    fun getCustomQuestionsByCategory(category: String): Flow<List<CustomQuestionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomQuestions(questions: List<CustomQuestionEntity>)

    @Query("DELETE FROM custom_questions WHERE id = :id")
    suspend fun deleteCustomQuestion(id: String)

    @Query("DELETE FROM custom_questions")
    suspend fun clearAllCustomQuestions()
}
