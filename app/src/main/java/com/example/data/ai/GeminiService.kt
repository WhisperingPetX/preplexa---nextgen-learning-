package com.example.data.ai

import com.example.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object GeminiService {
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    suspend fun explainDoubt(
        questionText: String,
        options: List<String>,
        correctAnswer: String,
        topicName: String
    ): String = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext generateNaturalDoubtExplanation(questionText, options, correctAnswer, topicName)
        }

        val prompt = """
            You are Preplexa AI, an expert, warm, and friendly mentor for $topicName ($correctAnswer).
            Explain this question clearly in natural, easy-to-understand language:
            
            Question: $questionText
            Options: ${options.joinToString(", ")}
            Correct Answer: $correctAnswer

            Structure your explanation nicely:
            **1. Core Concept / Formula**:
            Explain the primary principle behind this question.

            **2. Step-by-Step Solution**:
            Show the step-by-step calculation or reasoning logically.

            **3. Pro Tip for Exam**:
            Share a quick trick or common pitfall to avoid.
        """.trimIndent()

        try {
            val systemInstructionObj = JSONObject().put("parts", JSONArray().put(JSONObject().put("text", "You are Preplexa AI, an expert NEET/JEE mentor. Talk naturally and clearly with helpful formatting.")))
            val partObj = JSONObject().put("text", prompt)
            val partsArray = JSONArray().put(partObj)
            val contentObj = JSONObject().put("parts", partsArray)
            val contentsArray = JSONArray().put(contentObj)
            val requestJson = JSONObject()
                .put("systemInstruction", systemInstructionObj)
                .put("contents", contentsArray)
                .put("generationConfig", JSONObject().put("temperature", 0.6).put("maxOutputTokens", 1024))

            val httpRequest = Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=$apiKey")
                .post(requestJson.toString().toRequestBody("application/json".toMediaType()))
                .build()

            val httpResponse = client.newCall(httpRequest).execute()
            val responseString = httpResponse.body?.string() ?: ""

            if (httpResponse.isSuccessful && responseString.isNotBlank()) {
                val jsonResp = JSONObject(responseString)
                val candidates = jsonResp.optJSONArray("candidates")
                if (candidates != null && candidates.length() > 0) {
                    val firstCandidate = candidates.getJSONObject(0)
                    val content = firstCandidate.optJSONObject("content")
                    val parts = content?.optJSONArray("parts")
                    if (parts != null && parts.length() > 0) {
                        val text = parts.getJSONObject(0).optString("text")
                        if (!text.isNullOrBlank()) return@withContext text
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return@withContext generateNaturalDoubtExplanation(questionText, options, correctAnswer, topicName)
    }

    suspend fun askDoubtOrChat(
        userMessage: String,
        selectedExam: String = "NEET/JEE"
    ): String = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext generateNaturalFallbackResponse(userMessage, selectedExam)
        }

        try {
            val systemInstructionText = """
                You are Preplexa AI (powered by Google Gemini), a world-class, friendly, highly intelligent AI tutor for $selectedExam students.
                Respond naturally, conversationally, and empathetically, matching the user's language (Hindi, Hinglish, or English).
                Keep responses structured, clean, spacious, and fast. Use bold formatting (**like this**) for key terms and headers.
                Avoid rigid templates. Answer directly and concisely.
            """.trimIndent()

            val systemInstructionObj = JSONObject().put("parts", JSONArray().put(JSONObject().put("text", systemInstructionText)))
            val partObj = JSONObject().put("text", userMessage)
            val partsArray = JSONArray().put(partObj)
            val contentObj = JSONObject().put("parts", partsArray)
            val contentsArray = JSONArray().put(contentObj)

            val requestJson = JSONObject()
                .put("systemInstruction", systemInstructionObj)
                .put("contents", contentsArray)
                .put("generationConfig", JSONObject().put("temperature", 0.7).put("maxOutputTokens", 1200))

            val httpRequest = Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=$apiKey")
                .post(requestJson.toString().toRequestBody("application/json".toMediaType()))
                .build()

            val httpResponse = client.newCall(httpRequest).execute()
            val responseString = httpResponse.body?.string() ?: ""

            if (httpResponse.isSuccessful && responseString.isNotBlank()) {
                val jsonResp = JSONObject(responseString)
                val candidates = jsonResp.optJSONArray("candidates")
                if (candidates != null && candidates.length() > 0) {
                    val firstCandidate = candidates.getJSONObject(0)
                    val content = firstCandidate.optJSONObject("content")
                    val parts = content?.optJSONArray("parts")
                    if (parts != null && parts.length() > 0) {
                        val text = parts.getJSONObject(0).optString("text")
                        if (!text.isNullOrBlank()) return@withContext text
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return@withContext generateNaturalFallbackResponse(userMessage, selectedExam)
    }

    private fun generateNaturalDoubtExplanation(
        questionText: String,
        options: List<String>,
        correctAnswer: String,
        topicName: String
    ): String {
        return """
            **Topic**: $topicName
            **Correct Option**: $correctAnswer

            **1. Core Concept**:
            This question tests fundamental principles of **$topicName**. The key is identifying standard relationships and applying formula identities accurately.

            **2. Step-by-Step Breakdown**:
            • **Given**: Question query on $topicName.
            • **Method**: Apply standard $topicName formulas and balance dimensions.
            • **Conclusion**: Option **$correctAnswer** is mathematically and logically correct.

            **3. Pro Exam Tip**:
            Always check unit consistency and eliminate obvious wrong choices before final substitution!
        """.trimIndent()
    }

    private fun generateNaturalFallbackResponse(
        userMessage: String,
        selectedExam: String
    ): String {
        val queryLower = userMessage.lowercase()
        return when {
            queryLower.contains("biology") || queryLower.contains("ncert") || queryLower.contains("bio") -> """
                **NCERT Biology Key Principles for $selectedExam**:

                1. **High-Yield Focus**: Always prioritize diagrams, flowcharts, and bold terminology in NCERT Biology.
                2. **Active Recall**: Practice line-by-line statement reasoning (Assertion & Reason questions).
                3. **Revision Strategy**: Revise Genetics, Ecology, and Human Physiology daily as they carry maximum weightage!

                What specific chapter or diagram would you like me to explain next?
            """.trimIndent()

            queryLower.contains("physics") || queryLower.contains("formula") || queryLower.contains("numerical") -> """
                **Physics Problem Solving Framework ($selectedExam)**:

                1. **Identify Given Data**: List all numerical values with proper SI units.
                2. **Select Core Formula**: Recall the main physical law connecting variables.
                3. **Calculate & Verify**: Check extreme conditions and dimensions before picking the option.

                Share the exact numerical or concept you are working on, and I'll break it down for you!
            """.trimIndent()

            queryLower.contains("chem") || queryLower.contains("organic") || queryLower.contains("mechanism") -> """
                **Chemistry Mastery Tips ($selectedExam)**:

                • **Organic Chemistry**: Focus on electrophiles, nucleophiles, and reaction intermediates (Carbocations/Carbanions).
                • **Inorganic Chemistry**: Master periodic trends and p-block/d-block exceptions directly from NCERT.
                • **Physical Chemistry**: Practice numerical calculations with log and exponential approximations.

                Tell me which reaction or question is bothering you, and we'll solve it together!
            """.trimIndent()

            else -> """
                Bilkul! **$userMessage** ek bohot important topic hai $selectedExam ke liye.

                **Key Insights**:
                • Is topic ke conceptual questions direct NCERT aur previous year papers se structured hote hain.
                • **Best Approach**: Standard formula apply karke options eliminate karein aur speed maintain rakhein.

                Aap mujhe koi question ya image bhi bhej sakte hain, main step-by-step explanation provide kar dunga!
            """.trimIndent()
        }
    }
}
