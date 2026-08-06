package com.example.model

enum class ExamType(val displayName: String, val description: String, val badgeColorHex: String) {
    NEET_UG("NEET (UG)", "Medical Entrance (Physics, Chemistry, Biology)", "#10B981"),
    JEE_MAINS("JEE Mains", "Engineering Entrance (Physics, Chemistry, Math)", "#6366F1")
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

data class DayAvatarInfo(
    val dayOfWeek: Int, // Calendar.SUNDAY (1) .. Calendar.SATURDAY (7)
    val dayName: String,
    val avatarEmoji: String,
    val personaTitle: String,
    val themeColorHex: String
)

object DailyAvatarManager {
    val WEEKLY_AVATARS = listOf(
        DayAvatarInfo(java.util.Calendar.SUNDAY, "Sunday", "🫏", "Sunday Steadfast Donkey", "#FFB300"),
        DayAvatarInfo(java.util.Calendar.MONDAY, "Monday", "🚀", "Monday Rocket Pioneer", "#3D5AFE"),
        DayAvatarInfo(java.util.Calendar.TUESDAY, "Tuesday", "🐼", "Tuesday Power Panda", "#FF6D00"),
        DayAvatarInfo(java.util.Calendar.WEDNESDAY, "Wednesday", "🩺", "Wednesday Med Wizard", "#00E676"),
        DayAvatarInfo(java.util.Calendar.THURSDAY, "Thursday", "🐒", "Thursday Clever Monkey", "#AA00FF"),
        DayAvatarInfo(java.util.Calendar.FRIDAY, "Friday", "🦉", "Friday Night Owl", "#00B0FF"),
        DayAvatarInfo(java.util.Calendar.SATURDAY, "Saturday", "🏆", "Saturday Grand Legend", "#FFD600")
    )

    fun getTodayAvatarInfo(): DayAvatarInfo {
        val cal = java.util.Calendar.getInstance()
        val dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK)
        return WEEKLY_AVATARS.find { it.dayOfWeek == dayOfWeek } ?: WEEKLY_AVATARS[0]
    }

    fun getAvatarForDay(dayOfWeek: Int): DayAvatarInfo {
        return WEEKLY_AVATARS.find { it.dayOfWeek == dayOfWeek } ?: WEEKLY_AVATARS[0]
    }
}
