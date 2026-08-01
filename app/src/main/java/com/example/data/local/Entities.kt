package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_attempts")
data class TestAttemptEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val testId: String,
    val topicId: String,
    val examType: String,
    val scorePercent: Int,
    val correctCount: Int,
    val incorrectCount: Int,
    val unattemptedCount: Int,
    val totalQuestions: Int,
    val timeSpentSeconds: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "bookmarked_questions")
data class BookmarkedQuestionEntity(
    @PrimaryKey val questionId: String,
    val topicId: String,
    val questionText: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctOptionIndex: Int,
    val explanation: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "custom_questions")
data class CustomQuestionEntity(
    @PrimaryKey val id: String,
    val category: String, // "PYQ" or "LIBRARY_TOPIC"
    val subject: String, // "Physics", "Chemistry", "Biology", "Mathematics"
    val topicOrYear: String, // e.g. "2026" or "phy_kinematics"
    val questionText: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctOptionIndex: Int,
    val explanation: String,
    val timestamp: Long = System.currentTimeMillis()
)
