package com.example.ui.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.ai.GeminiService
import com.example.data.local.*
import com.example.data.repository.SyllabusRepository
import com.example.data.supabase.*
import com.example.model.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

enum class Screen {
    HOME,
    TOPIC_LIST,
    MOCK_TEST_SERIES_LIST,
    QUIZ_ATTEMPT,
    TEST_RESULT,
    BOOKMARKS,
    ANALYTICS,
    PYQ_PAPERS,
    PROFILE,
    AUTH
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val dao: PreplexaDao = PreplexaDatabase.getDatabase(application).preplexaDao()
    val supabaseService = SupabaseService(application)

    // --- Supabase Cloud Sync & Auth State ---
    private val _supabaseStatus = MutableStateFlow(
        SupabaseStatus(
            isConnected = SupabaseConfig.isConfigured(application),
            userEmail = SupabaseConfig.getUserEmail(application),
            userId = SupabaseConfig.getUserId(application)
        )
    )
    val supabaseStatus: StateFlow<SupabaseStatus> = _supabaseStatus.asStateFlow()

    // --- Student Profile Customization ---
    private val userPrefs = application.getSharedPreferences("user_profile_prefs", Context.MODE_PRIVATE)

    // --- Theme & Dark Mode State ---
    private val _isDarkMode = MutableStateFlow(
        userPrefs.getBoolean("is_dark_mode", false)
    )
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    fun toggleDarkMode() {
        val newValue = !_isDarkMode.value
        _isDarkMode.value = newValue
        userPrefs.edit().putBoolean("is_dark_mode", newValue).apply()
    }

    fun setDarkMode(enabled: Boolean) {
        _isDarkMode.value = enabled
        userPrefs.edit().putBoolean("is_dark_mode", enabled).apply()
    }

    private val _studentName = MutableStateFlow(
        userPrefs.getString("student_name", null) ?: SupabaseConfig.getUserEmail(application)?.substringBefore("@")?.replaceFirstChar { it.uppercase() } ?: "Aspirant"
    )
    val studentName: StateFlow<String> = _studentName.asStateFlow()

    private val _isAvatarAutoRotating = MutableStateFlow(
        userPrefs.getBoolean("avatar_auto_rotate", true)
    )
    val isAvatarAutoRotating: StateFlow<Boolean> = _isAvatarAutoRotating.asStateFlow()

    private val _studentAvatar = MutableStateFlow(
        if (userPrefs.getBoolean("avatar_auto_rotate", true) || userPrefs.getString("student_avatar", "AUTO") == "AUTO") {
            com.example.model.DailyAvatarManager.getTodayAvatarInfo().avatarEmoji
        } else {
            userPrefs.getString("student_avatar", com.example.model.DailyAvatarManager.getTodayAvatarInfo().avatarEmoji) ?: com.example.model.DailyAvatarManager.getTodayAvatarInfo().avatarEmoji
        }
    )
    val studentAvatar: StateFlow<String> = _studentAvatar.asStateFlow()

    private fun refreshDailyAvatar() {
        val isAuto = userPrefs.getBoolean("avatar_auto_rotate", true) || userPrefs.getString("student_avatar", "AUTO") == "AUTO"
        if (isAuto) {
            val todayInfo = com.example.model.DailyAvatarManager.getTodayAvatarInfo()
            _studentAvatar.value = todayInfo.avatarEmoji
            _isAvatarAutoRotating.value = true
        } else {
            _isAvatarAutoRotating.value = false
            _studentAvatar.value = userPrefs.getString("student_avatar", com.example.model.DailyAvatarManager.getTodayAvatarInfo().avatarEmoji) ?: com.example.model.DailyAvatarManager.getTodayAvatarInfo().avatarEmoji
        }
    }

    // --- Streak State ---
    private val _currentStreak = MutableStateFlow(userPrefs.getInt("current_streak", 1))
    val currentStreak: StateFlow<Int> = _currentStreak.asStateFlow()
    
    private val _streakHistory = MutableStateFlow<List<Triple<String, Boolean, String>>>(emptyList())
    val streakHistory: StateFlow<List<Triple<String, Boolean, String>>> = _streakHistory.asStateFlow()

    // --- Live Arena Real-Time Stats ---
    private val _liveArenaStats = MutableStateFlow(com.example.data.supabase.SupabaseLiveArenaDto())
    val liveArenaStats: StateFlow<com.example.data.supabase.SupabaseLiveArenaDto> = _liveArenaStats.asStateFlow()

    init {
        refreshDailyAvatar()
        updateStreak()
        viewModelScope.launch {
            val arenaRes = supabaseService.fetchLiveArenaStats()
            if (arenaRes.isSuccess) {
                arenaRes.getOrNull()?.let { _liveArenaStats.value = it }
            }
        }
        // Pre-populate PYQ Questions
        viewModelScope.launch {
            if (!userPrefs.getBoolean("pyq_2024_loaded", false)) {
                dao.insertCustomQuestions(com.example.data.repository.JeeMain2024Jan27Shift1.questions)
                userPrefs.edit().putBoolean("pyq_2024_loaded", true).apply()
            }
        }
    }

    fun updateStreak() {
        refreshDailyAvatar()
        val lastActiveDate = userPrefs.getString("last_active_date", "")
        val dateFormat = java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault())
        val currentDate = dateFormat.format(java.util.Date())

        var streak = userPrefs.getInt("current_streak", 0)

        if (lastActiveDate != currentDate) {
            if (lastActiveDate.isNullOrEmpty()) {
                streak = 1
            } else {
                try {
                    val cal = java.util.Calendar.getInstance()
                    cal.add(java.util.Calendar.DAY_OF_YEAR, -1)
                    val yesterday = dateFormat.format(cal.time)
                    
                    if (lastActiveDate == yesterday) {
                        streak += 1
                    } else {
                        streak = 1
                    }
                } catch (e: Exception) {
                    streak = 1
                }
            }
            userPrefs.edit()
                .putString("last_active_date", currentDate)
                .putInt("current_streak", streak)
                .apply()
        }
        if (streak == 0) streak = 1 

        _currentStreak.value = streak

        val historyList = mutableListOf<Triple<String, Boolean, String>>()
        val calUI = java.util.Calendar.getInstance()
        val dayFormat = java.text.SimpleDateFormat("E", java.util.Locale.getDefault()) 
        
        calUI.add(java.util.Calendar.DAY_OF_YEAR, -6)
        
        for (i in 0..6) {
            val dayName = dayFormat.format(calUI.time)
            val initial = dayName.take(1)
            val isActive = streak > (6 - i)
            historyList.add(Triple(initial, isActive, dayName))
            calUI.add(java.util.Calendar.DAY_OF_YEAR, 1)
        }
        _streakHistory.value = historyList
    }

    fun updateStudentProfile(name: String, avatar: String, autoRotate: Boolean = false) {
        val trimmedName = name.trim().ifEmpty { "Aspirant" }
        _studentName.value = trimmedName
        _isAvatarAutoRotating.value = autoRotate
        
        val newAvatar = if (autoRotate) {
            com.example.model.DailyAvatarManager.getTodayAvatarInfo().avatarEmoji
        } else {
            avatar
        }
        _studentAvatar.value = newAvatar

        userPrefs.edit()
            .putString("student_name", trimmedName)
            .putString("student_avatar", if (autoRotate) "AUTO" else avatar)
            .putBoolean("avatar_auto_rotate", autoRotate)
            .apply()
    }

    // --- State Navigation ---
    private val _currentScreen = MutableStateFlow(
        if (!SupabaseConfig.getUserEmail(application).isNullOrBlank() || !SupabaseConfig.getUserId(application).isNullOrBlank()) Screen.HOME else Screen.AUTH
    )
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    // --- Exam & Subject Filters ---
    private val _selectedExam = MutableStateFlow(ExamType.NEET_UG)
    val selectedExam: StateFlow<ExamType> = _selectedExam.asStateFlow()

    private val _selectedSubject = MutableStateFlow<Subject?>(null)
    val selectedSubject: StateFlow<Subject?> = _selectedSubject.asStateFlow()

    // --- Admin News / Notifications ---
    private val _adminNewsList = MutableStateFlow<List<String>>(
        userPrefs.getStringSet("admin_news_list", setOf("Welcome to Preplexa! Start your preparation today."))?.toList() ?: listOf("Welcome to Preplexa! Start your preparation today.")
    )
    val adminNewsList: StateFlow<List<String>> = _adminNewsList.asStateFlow()

    fun addAdminNews(news: String) {
        val currentList = _adminNewsList.value.toMutableList()
        currentList.add(0, news) // Add to top
        _adminNewsList.value = currentList
        userPrefs.edit().putStringSet("admin_news_list", currentList.toSet()).apply()
    }
    
    fun removeAdminNews(news: String) {
        val currentList = _adminNewsList.value.toMutableList()
        currentList.remove(news)
        _adminNewsList.value = currentList
        userPrefs.edit().putStringSet("admin_news_list", currentList.toSet()).apply()
    }

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    // --- Selected Topic & Mock Test Series ---
    private val _selectedTopic = MutableStateFlow<Topic?>(null)
    val selectedTopic: StateFlow<Topic?> = _selectedTopic.asStateFlow()

    private val _mockTestSeries = MutableStateFlow<List<MockTest>>(emptyList())
    val mockTestSeries: StateFlow<List<MockTest>> = _mockTestSeries.asStateFlow()

    // --- Active Quiz / Mock Test ---
    private val _activeTest = MutableStateFlow<MockTest?>(null)
    val activeTest: StateFlow<MockTest?> = _activeTest.asStateFlow()

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions.asStateFlow()

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex.asStateFlow()

    private val _userAnswers = MutableStateFlow<Map<String, UserAnswer>>(emptyMap())
    val userAnswers: StateFlow<Map<String, UserAnswer>> = _userAnswers.asStateFlow()

    private val _timeRemainingSeconds = MutableStateFlow(0)
    val timeRemainingSeconds: StateFlow<Int> = _timeRemainingSeconds.asStateFlow()

    private var timerJob: Job? = null

    // --- Test Result & AI Doubt State ---
    private val _latestResult = MutableStateFlow<TestResult?>(null)
    val latestResult: StateFlow<TestResult?> = _latestResult.asStateFlow()

    private val _aiDoubtExplanation = MutableStateFlow<String?>(null)
    val aiDoubtExplanation: StateFlow<String?> = _aiDoubtExplanation.asStateFlow()

    private val _isLoadingAiDoubt = MutableStateFlow(false)
    val isLoadingAiDoubt: StateFlow<Boolean> = _isLoadingAiDoubt.asStateFlow()

    // --- Room Database Flows ---
    val allAttempts: StateFlow<List<TestAttemptEntity>> = dao.getAllTestAttempts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val bookmarkedQuestions: StateFlow<List<BookmarkedQuestionEntity>> = dao.getAllBookmarks()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val customQuestions: StateFlow<List<CustomQuestionEntity>> = dao.getAllCustomQuestions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // --- Admin Preferences & App Notice ---
    private val adminPrefs = application.getSharedPreferences("admin_app_prefs", Context.MODE_PRIVATE)

    private val _appUpdateNotice = MutableStateFlow(
        adminPrefs.getString("app_update_notice", "") ?: ""
    )
    val appUpdateNotice: StateFlow<String> = _appUpdateNotice.asStateFlow()

    fun updateAppNotice(notice: String) {
        _appUpdateNotice.value = notice
        adminPrefs.edit().putString("app_update_notice", notice).apply()
    }

    private val _monthlyPrice = MutableStateFlow(adminPrefs.getString("price_monthly", "99") ?: "99")
    val monthlyPrice: StateFlow<String> = _monthlyPrice.asStateFlow()

    private val _sixMonthPrice = MutableStateFlow(adminPrefs.getString("price_6months", "499") ?: "499")
    val sixMonthPrice: StateFlow<String> = _sixMonthPrice.asStateFlow()

    private val _yearlyPrice = MutableStateFlow(adminPrefs.getString("price_yearly", "1099") ?: "1099")
    val yearlyPrice: StateFlow<String> = _yearlyPrice.asStateFlow()

    fun updateSubscriptionPrices(monthly: String, sixMonths: String, yearly: String) {
        _monthlyPrice.value = monthly
        _sixMonthPrice.value = sixMonths
        _yearlyPrice.value = yearly
        adminPrefs.edit()
            .putString("price_monthly", monthly)
            .putString("price_6months", sixMonths)
            .putString("price_yearly", yearly)
            .apply()
    }

    // --- Subscription & 30-Day Free Trial Management ---
    private val subPrefs = application.getSharedPreferences("subscription_prefs", Context.MODE_PRIVATE)

    private val _firstLaunchTime = subPrefs.getLong("trial_start_timestamp", 0L).let { stored ->
        if (stored == 0L) {
            val now = System.currentTimeMillis()
            subPrefs.edit().putLong("trial_start_timestamp", now).apply()
            now
        } else {
            stored
        }
    }

    private val _isSubscribed = MutableStateFlow(subPrefs.getBoolean("is_subscribed", false))
    val isSubscribed: StateFlow<Boolean> = _isSubscribed.asStateFlow()

    private val _subscriptionPlan = MutableStateFlow(subPrefs.getString("subscription_plan", "30_day_trial") ?: "30_day_trial")
    val subscriptionPlan: StateFlow<String> = _subscriptionPlan.asStateFlow()

    private fun calculateRemainingDays(): Int {
        val overrideDays = subPrefs.getInt("override_trial_days", -1)
        if (overrideDays >= 0) return overrideDays
        val now = System.currentTimeMillis()
        val daysElapsed = ((now - _firstLaunchTime) / (1000L * 60 * 60 * 24)).toInt()
        return maxOf(0, 30 - daysElapsed)
    }

    private val _trialDaysRemaining = MutableStateFlow(calculateRemainingDays())
    val trialDaysRemaining: StateFlow<Int> = _trialDaysRemaining.asStateFlow()

    private val _isServiceLocked = MutableStateFlow(!_isSubscribed.value && _trialDaysRemaining.value <= 0)
    val isServiceLocked: StateFlow<Boolean> = _isServiceLocked.asStateFlow()

    private val _showPaywallModal = MutableStateFlow(false)
    val showPaywallModal: StateFlow<Boolean> = _showPaywallModal.asStateFlow()

    fun updateTrialState() {
        val remaining = calculateRemainingDays()
        _trialDaysRemaining.value = remaining
        _isServiceLocked.value = !_isSubscribed.value && remaining <= 0
    }

    fun activateSubscription(planName: String) {
        _isSubscribed.value = true
        _subscriptionPlan.value = planName
        _isServiceLocked.value = false
        subPrefs.edit()
            .putBoolean("is_subscribed", true)
            .putString("subscription_plan", planName)
            .apply()
        _showPaywallModal.value = false
    }

    fun setTrialOverride(days: Int) {
        subPrefs.edit().putInt("override_trial_days", days).apply()
        updateTrialState()
    }

    fun resetSubscriptionStatus(subscribed: Boolean) {
        _isSubscribed.value = subscribed
        subPrefs.edit().putBoolean("is_subscribed", subscribed).apply()
        updateTrialState()
    }

    fun triggerPaywallModal() {
        _showPaywallModal.value = true
    }

    fun dismissPaywallModal() {
        _showPaywallModal.value = false
    }

    fun checkServiceAccessAndRun(action: () -> Unit) {
        updateTrialState()
        if (_isServiceLocked.value) {
            _showPaywallModal.value = true
        } else {
            action()
        }
    }

    fun insertCustomQuestions(questions: List<CustomQuestionEntity>) {
        viewModelScope.launch {
            dao.insertCustomQuestions(questions)
        }
    }

    fun deleteCustomQuestion(id: String) {
        viewModelScope.launch {
            dao.deleteCustomQuestion(id)
        }
    }

    fun clearAllCustomQuestions() {
        viewModelScope.launch {
            dao.clearAllCustomQuestions()
        }
    }

    // --- Filtered Topics ---
    val filteredTopics: StateFlow<List<Topic>> = combine(
        _selectedExam,
        _selectedSubject,
        _searchQuery
    ) { exam, subject, query ->
        SyllabusRepository.allTopics.filter { topic ->
            val matchesExam = topic.examTypes.contains(exam)
            val matchesSubject = subject == null || topic.subject == subject
            val matchesQuery = query.isBlank() ||
                    topic.title.contains(query, ignoreCase = true) ||
                    topic.description.contains(query, ignoreCase = true) ||
                    topic.subtopics.any { it.contains(query, ignoreCase = true) }
            matchesExam && matchesSubject && matchesQuery
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // --- Methods ---

    fun selectExam(exam: ExamType) {
        _selectedExam.value = exam
        _selectedSubject.value = null
    }

    fun selectSubject(subject: Subject?) {
        _selectedSubject.value = subject
        _currentScreen.value = Screen.TOPIC_LIST
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun navigateToScreen(screen: Screen) {
        _currentScreen.value = screen
    }

    fun selectTopic(topic: Topic) {
        _selectedTopic.value = topic
        // Load the 10 Mock Tests for this topic!
        val series = SyllabusRepository.getMockTestSeriesForTopic(topic.id)
        
        // Enrich with completed best score from database attempts
        viewModelScope.launch {
            val attempts = dao.getAttemptsForTopic(topic.id).firstOrNull() ?: emptyList()
            val enrichedSeries = series.map { test ->
                val best = attempts.filter { it.testId == test.id }.maxOfOrNull { it.scorePercent }
                if (best != null) {
                    test.copy(isCompleted = true, bestScorePercent = best)
                } else {
                    test
                }
            }
            _mockTestSeries.value = enrichedSeries
            _currentScreen.value = Screen.MOCK_TEST_SERIES_LIST
        }
    }

    fun startMockTest(mockTest: MockTest) {
        if (_isServiceLocked.value) {
            _showPaywallModal.value = true
            return
        }
        _activeTest.value = mockTest
        val repoQuestions = SyllabusRepository.getQuestionsForMockTest(mockTest.id, mockTest.topicId)
        
        // Find matching custom questions from database
        val matchingCustom = customQuestions.value.filter { 
            it.topicOrYear == mockTest.topicId || 
            (it.category == "PYQ" && mockTest.id.contains(it.topicOrYear))
        }.map { entity ->
            Question(
                id = entity.id,
                topicId = entity.topicOrYear,
                text = entity.questionText,
                options = listOf(entity.optionA, entity.optionB, entity.optionC, entity.optionD),
                correctOptionIndex = entity.correctOptionIndex,
                explanation = entity.explanation,
                difficulty = "Medium",
                formulaRef = "Custom Extracted PDF Question"
            )
        }

        val qList = if (matchingCustom.isNotEmpty()) matchingCustom + repoQuestions else repoQuestions

        _activeTest.value = mockTest.copy(
            questionCount = qList.size,
            subtitle = "${qList.size} Questions • ${mockTest.durationMinutes} Mins • Official NTA CBT Exam Mode"
        )
        _questions.value = qList
        _userAnswers.value = emptyMap()
        _currentQuestionIndex.value = 0
        _timeRemainingSeconds.value = mockTest.durationMinutes * 60
        _latestResult.value = null
        _currentScreen.value = Screen.QUIZ_ATTEMPT

        startTimer()
    }

    fun startPyqTest(year: Int, examType: ExamType, title: String, session: Int? = null, shift: Int? = null) {
        val topicId = if (examType == ExamType.NEET_UG) "phy_units_and_measurements" else "phy_kinematics"
        val qCount = if (examType == ExamType.NEET_UG) {
            if (year >= 2021) 200 else 180
        } else {
            75
        }
        val duration = 180
        val sessionStr = session?.let { " Session $it" } ?: ""
        val shiftStr = shift?.let { " Shift $it" } ?: ""
        val fullTitle = if (session != null && shift != null) {
            "$title - Session $session (Shift $shift)"
        } else {
            "$title ($year Official Paper)"
        }
        val testId = if (session != null && shift != null) {
            "pyq_${examType.name.lowercase()}_${year}_s${session}_sh${shift}"
        } else {
            "pyq_${examType.name.lowercase()}_$year"
        }
        val mockTest = MockTest(
            id = testId,
            topicId = topicId,
            testNumber = year,
            title = fullTitle,
            subtitle = "$qCount Questions • $duration Mins • Official NTA CBT Exam Mode$sessionStr$shiftStr",
            questionCount = qCount,
            durationMinutes = duration,
            difficulty = "Official NTA Level"
        )
        startMockTest(mockTest)
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_timeRemainingSeconds.value > 0) {
                delay(1000)
                _timeRemainingSeconds.value -= 1
            }
            // Auto submit if timer runs out
            if (_currentScreen.value == Screen.QUIZ_ATTEMPT) {
                submitMockTest()
            }
        }
    }

    fun selectOption(questionId: String, optionIndex: Int) {
        val current = _userAnswers.value[questionId]
        val updated = current?.copy(selectedOptionIndex = optionIndex)
            ?: UserAnswer(questionId = questionId, selectedOptionIndex = optionIndex)
        _userAnswers.value = _userAnswers.value + (questionId to updated)
    }

    fun toggleMarkForReview(questionId: String) {
        val current = _userAnswers.value[questionId]
        val updated = current?.copy(isMarkedForReview = !(current.isMarkedForReview))
            ?: UserAnswer(questionId = questionId, selectedOptionIndex = null, isMarkedForReview = true)
        _userAnswers.value = _userAnswers.value + (questionId to updated)
    }

    fun setCurrentQuestionIndex(index: Int) {
        if (index in 0 until _questions.value.size) {
            _currentQuestionIndex.value = index
        }
    }

    fun exitQuizTest(targetScreen: Screen = Screen.PYQ_PAPERS) {
        timerJob?.cancel()
        _activeTest.value = null
        _questions.value = emptyList()
        _userAnswers.value = emptyMap()
        _currentScreen.value = targetScreen
    }

    fun submitMockTest() {
        timerJob?.cancel()
        val test = _activeTest.value ?: return
        val qList = _questions.value
        val answers = _userAnswers.value
        val topic = _selectedTopic.value ?: SyllabusRepository.allTopics.first()

        var correct = 0
        var incorrect = 0
        var unattempted = 0

        val questionDetails = qList.map { q ->
            val userAns = answers[q.id]?.selectedOptionIndex
            val isCorr = userAns == q.correctOptionIndex
            if (userAns == null) {
                unattempted++
            } else if (isCorr) {
                correct++
            } else {
                incorrect++
            }
            QuestionResultDetail(question = q, selectedOptionIndex = userAns, isCorrect = isCorr)
        }

        val total = qList.size
        val scorePercent = if (total > 0) (correct * 100) / total else 0
        val timeSpent = (test.durationMinutes * 60) - _timeRemainingSeconds.value

        val result = TestResult(
            testId = test.id,
            topicId = test.topicId,
            topicTitle = test.title,
            totalQuestions = total,
            correctCount = correct,
            incorrectCount = incorrect,
            unattemptedCount = unattempted,
            scorePercent = scorePercent,
            timeSpentSeconds = timeSpent,
            questionDetails = questionDetails
        )

        _latestResult.value = result

        // Save attempt to Room Database
        viewModelScope.launch {
            dao.insertAttempt(
                TestAttemptEntity(
                    testId = test.id,
                    topicId = test.topicId,
                    examType = _selectedExam.value.name,
                    scorePercent = scorePercent,
                    correctCount = correct,
                    incorrectCount = incorrect,
                    unattemptedCount = unattempted,
                    totalQuestions = total,
                    timeSpentSeconds = timeSpent
                )
            )
        }

        _currentScreen.value = Screen.TEST_RESULT
        
        // Auto trigger Supabase Cloud sync after completing a test
        syncWithSupabase()
    }

    fun toggleBookmark(question: Question) {
        viewModelScope.launch {
            val isBookmarked = dao.isQuestionBookmarked(question.id).firstOrNull() ?: false
            if (isBookmarked) {
                dao.removeBookmark(question.id)
            } else {
                dao.bookmarkQuestion(
                    BookmarkedQuestionEntity(
                        questionId = question.id,
                        topicId = question.topicId,
                        questionText = question.text,
                        optionA = question.options.getOrElse(0) { "" },
                        optionB = question.options.getOrElse(1) { "" },
                        optionC = question.options.getOrElse(2) { "" },
                        optionD = question.options.getOrElse(3) { "" },
                        correctOptionIndex = question.correctOptionIndex,
                        explanation = question.explanation
                    )
                )
            }
            syncWithSupabase()
        }
    }

    fun isBookmarked(questionId: String): Flow<Boolean> = dao.isQuestionBookmarked(questionId)

    fun askAiDoubt(question: Question) {
        if (_isServiceLocked.value) {
            _showPaywallModal.value = true
            return
        }
        _aiDoubtExplanation.value = null
        _isLoadingAiDoubt.value = true
        viewModelScope.launch {
            val topicName = _selectedTopic.value?.title ?: "Subject Concept"
            val corrText = question.options.getOrElse(question.correctOptionIndex) { "Correct Option" }
            val explanation = GeminiService.explainDoubt(
                questionText = question.text,
                options = question.options,
                correctAnswer = corrText,
                topicName = topicName
            )
            _aiDoubtExplanation.value = explanation
            _isLoadingAiDoubt.value = false
        }
    }

    // --- Supabase Backend Actions ---

    fun syncWithSupabase() {
        viewModelScope.launch {
            _supabaseStatus.update { it.copy(syncState = SupabaseSyncState.SYNCING, errorMessage = null) }
            
            try {
                val attempts = dao.getAllTestAttempts().firstOrNull() ?: emptyList()
                val bookmarks = dao.getAllBookmarks().firstOrNull() ?: emptyList()
                
                val attemptDtos = attempts.map { att ->
                    SupabaseTestAttemptDto(
                        id = att.id,
                        testId = att.testId,
                        topicId = att.topicId,
                        examType = att.examType,
                        scorePercent = att.scorePercent,
                        correctCount = att.correctCount,
                        incorrectCount = att.incorrectCount,
                        unattemptedCount = att.unattemptedCount,
                        totalQuestions = att.totalQuestions,
                        timeSpentSeconds = att.timeSpentSeconds,
                        timestamp = att.timestamp,
                        userId = SupabaseConfig.getUserId(getApplication())
                    )
                }

                val bookmarkDtos = bookmarks.map { bm ->
                    SupabaseBookmarkDto(
                        questionId = bm.questionId,
                        topicId = bm.topicId,
                        questionText = bm.questionText,
                        optionA = bm.optionA,
                        optionB = bm.optionB,
                        optionC = bm.optionC,
                        optionD = bm.optionD,
                        correctOptionIndex = bm.correctOptionIndex,
                        explanation = bm.explanation,
                        userId = SupabaseConfig.getUserId(getApplication())
                    )
                }

                val syncAttemptsResult = supabaseService.syncTestAttempts(attemptDtos)
                val syncBookmarksResult = supabaseService.syncBookmarks(bookmarkDtos)

                val newsResult = supabaseService.fetchAdminNews()
                if (newsResult.isSuccess) {
                    val remoteNews = newsResult.getOrNull()?.map { "${it.title}: ${it.content}" }
                    if (!remoteNews.isNullOrEmpty()) {
                        _adminNewsList.value = remoteNews
                    }
                }

                val arenaResult = supabaseService.fetchLiveArenaStats()
                if (arenaResult.isSuccess) {
                    arenaResult.getOrNull()?.let { stats ->
                        _liveArenaStats.value = stats
                    }
                }

                if (syncAttemptsResult.isSuccess || syncBookmarksResult.isSuccess || newsResult.isSuccess) {
                    _supabaseStatus.update { 
                        it.copy(
                            isConnected = true,
                            syncState = SupabaseSyncState.SUCCESS,
                            lastSyncedTime = System.currentTimeMillis()
                        ) 
                    }
                } else {
                    val err = syncAttemptsResult.exceptionOrNull()?.message ?: syncBookmarksResult.exceptionOrNull()?.message ?: "Supabase Sync Error"
                    _supabaseStatus.update { 
                        it.copy(
                            syncState = SupabaseSyncState.ERROR,
                            errorMessage = err
                        ) 
                    }
                }
            } catch (e: Exception) {
                _supabaseStatus.update { 
                    it.copy(
                        syncState = SupabaseSyncState.ERROR,
                        errorMessage = e.localizedMessage ?: "Sync Error"
                    ) 
                }
            }
        }
    }

    fun signUpSupabase(email: String, pass: String, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            val res = supabaseService.signUp(email, pass)
            if (res.isSuccess) {
                val data = res.getOrNull()
                _supabaseStatus.update {
                    it.copy(
                        isConnected = true,
                        userEmail = data?.user?.email ?: email,
                        userId = data?.user?.id
                    )
                }
                onResult(true, null)
                syncWithSupabase()
            } else {
                onResult(false, res.exceptionOrNull()?.message ?: "Sign up failed")
            }
        }
    }

    fun signInSupabase(email: String, pass: String, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            val res = supabaseService.signIn(email, pass)
            if (res.isSuccess) {
                val data = res.getOrNull()
                _supabaseStatus.update {
                    it.copy(
                        isConnected = true,
                        userEmail = data?.user?.email ?: email,
                        userId = data?.user?.id
                    )
                }
                onResult(true, null)
                syncWithSupabase()
            } else {
                onResult(false, res.exceptionOrNull()?.message ?: "Sign in failed")
            }
        }
    }

    fun signInWithGoogle(email: String, displayName: String?, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val fakeUserId = "google_${email.hashCode().toString().replace("-", "0")}"
                SupabaseConfig.saveSession(
                    getApplication(),
                    accessToken = "sb_google_user_session_token",
                    refreshToken = "sb_google_refresh_token",
                    userId = fakeUserId,
                    email = email
                )
                _supabaseStatus.update {
                    it.copy(
                        isConnected = true,
                        userEmail = email,
                        userId = fakeUserId
                    )
                }
                displayName?.let { name ->
                    if (name.isNotBlank()) {
                        updateStudentProfile(name, "🌟")
                    }
                }
                onResult(true, null)
                syncWithSupabase()
            } catch (e: Exception) {
                onResult(false, e.message ?: "Google login failed")
            }
        }
    }

    fun signOutSupabase() {
        SupabaseConfig.clearSession(getApplication())
        _supabaseStatus.update {
            it.copy(
                userEmail = null,
                userId = null,
                syncState = SupabaseSyncState.IDLE
            )
        }
        _currentScreen.value = Screen.AUTH
    }

    fun updateSupabaseCredentials(url: String, anonKey: String) {
        SupabaseConfig.saveCustomConfig(getApplication(), url, anonKey)
        _supabaseStatus.update {
            it.copy(
                isConnected = SupabaseConfig.isConfigured(getApplication())
            )
        }
        syncWithSupabase()
    }
}
