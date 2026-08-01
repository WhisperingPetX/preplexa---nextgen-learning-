package com.example.model

enum class ExamType(val displayName: String, val description: String, val badgeColorHex: String) {
    NEET_UG("NEET (UG)", "Medical Entrance (Physics, Chemistry, Biology)", "#10B981"),
    JEE_MAINS("JEE Mains", "Engineering Entrance (Physics, Chemistry, Maths)", "#6366F1")
}

enum class Subject(val id: String, val displayName: String, val iconName: String, val colorHex: String) {
    PHYSICS("physics", "Physics", "bolt", "#38BDF8"),
    CHEMISTRY("chemistry", "Chemistry", "science", "#F43F5E"),
    MATHEMATICS("maths", "Mathematics", "calculate", "#6366F1"),
    BIOLOGY("biology", "Biology", "biomedical", "#10B981")
}

data class Topic(
    val id: String,
    val unitNumber: Int,
    val title: String,
    val subject: Subject,
    val examTypes: List<ExamType>,
    val description: String,
    val keyFormulae: List<String>,
    val subtopics: List<String>
)

data class Question(
    val id: String,
    val topicId: String,
    val text: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanation: String,
    val difficulty: String = "Medium",
    val formulaRef: String? = null
)

data class MockTest(
    val id: String,
    val topicId: String,
    val testNumber: Int, // 1 to 10
    val title: String,
    val subtitle: String,
    val questionCount: Int = 10,
    val durationMinutes: Int = 15,
    val difficulty: String, // "Easy", "NTA Standard", "PYQ Special", "Advanced Challenge"
    val isCompleted: Boolean = false,
    val bestScorePercent: Int? = null
)

data class UserAnswer(
    val questionId: String,
    val selectedOptionIndex: Int?, // null if unattempted
    val isMarkedForReview: Boolean = false
)

data class TestResult(
    val testId: String,
    val topicId: String,
    val topicTitle: String,
    val totalQuestions: Int,
    val correctCount: Int,
    val incorrectCount: Int,
    val unattemptedCount: Int,
    val scorePercent: Int,
    val timeSpentSeconds: Int,
    val timestamp: Long = System.currentTimeMillis(),
    val questionDetails: List<QuestionResultDetail>
)

data class QuestionResultDetail(
    val question: Question,
    val selectedOptionIndex: Int?,
    val isCorrect: Boolean
)
