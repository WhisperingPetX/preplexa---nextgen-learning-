package com.example.data.supabase

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SupabaseAuthRequest(
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String
)

@JsonClass(generateAdapter = true)
data class SupabaseAuthResponse(
    @Json(name = "access_token") val accessToken: String?,
    @Json(name = "token_type") val tokenType: String?,
    @Json(name = "refresh_token") val refreshToken: String?,
    @Json(name = "user") val user: SupabaseUserDto?
)

@JsonClass(generateAdapter = true)
data class SupabaseUserDto(
    @Json(name = "id") val id: String,
    @Json(name = "email") val email: String?,
    @Json(name = "role") val role: String? = null,
    @Json(name = "created_at") val createdAt: String? = null
)

@JsonClass(generateAdapter = true)
data class SupabaseTestAttemptDto(
    @Json(name = "id") val id: Long = 0,
    @Json(name = "test_id") val testId: String,
    @Json(name = "topic_id") val topicId: String,
    @Json(name = "exam_type") val examType: String,
    @Json(name = "score_percent") val scorePercent: Int,
    @Json(name = "correct_count") val correctCount: Int,
    @Json(name = "incorrect_count") val incorrectCount: Int,
    @Json(name = "unattempted_count") val unattemptedCount: Int,
    @Json(name = "total_questions") val totalQuestions: Int,
    @Json(name = "time_spent_seconds") val timeSpentSeconds: Int,
    @Json(name = "timestamp") val timestamp: Long,
    @Json(name = "user_id") val userId: String? = null
)

@JsonClass(generateAdapter = true)
data class SupabaseBookmarkDto(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "question_id") val questionId: String,
    @Json(name = "topic_id") val topicId: String,
    @Json(name = "question_text") val questionText: String,
    @Json(name = "option_a") val optionA: String,
    @Json(name = "option_b") val optionB: String,
    @Json(name = "option_c") val optionC: String,
    @Json(name = "option_d") val optionD: String,
    @Json(name = "correct_option_index") val correctOptionIndex: Int,
    @Json(name = "explanation") val explanation: String,
    @Json(name = "user_id") val userId: String? = null
)

@JsonClass(generateAdapter = true)
data class SupabaseUserProfileDto(
    @Json(name = "id") val id: String,
    @Json(name = "email") val email: String?,
    @Json(name = "total_tests_completed") val totalTestsCompleted: Int,
    @Json(name = "avg_accuracy") val avgAccuracy: Int,
    @Json(name = "last_synced_at") val lastSyncedAt: Long
)

enum class SupabaseSyncState {
    IDLE,
    SYNCING,
    SUCCESS,
    ERROR
}

data class SupabaseStatus(
    val isConnected: Boolean = false,
    val userEmail: String? = null,
    val userId: String? = null,
    val syncState: SupabaseSyncState = SupabaseSyncState.IDLE,
    val lastSyncedTime: Long? = null,
    val errorMessage: String? = null
)
