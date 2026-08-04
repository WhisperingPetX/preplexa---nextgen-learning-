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
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    suspend fun explainDoubt(
        questionText: String,
        options: List<String>,
        correctAnswer: String,
        topicName: String
    ): String = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext """
                💡 **Preplexa AI Detailed Mentor Solution**:
                
                - **Topic**: $topicName
                - **Question**: $questionText
                - **Correct Choice**: $correctAnswer
                
                **Step-by-Step Concept Breakdown**:
                1. **Formula & Identity**: Identify the standard NTA equation/concept for $topicName.
                2. **Substitution**: Insert given values and solve algebraically.
                3. **Verification**: Check dimensions, units, and boundary conditions.
                
                *(Add your Gemini API Key in AI Studio Secrets to activate live interactive AI Doubt Solver!)*
            """.trimIndent()
        }

        val prompt = """
            You are Preplexa AI, an expert mentor for NEET UG and JEE Mains.
            Explain this question in detail:
            Topic: $topicName
            Question: $questionText
            Options: ${options.joinToString(", ")}
            Correct Answer: $correctAnswer

            Break down the answer into:
            1. Core Formula / Concept
            2. Step-by-Step Solution
            3. Common NTA Exam Trap / Tip
        """.trimIndent()

        try {
            val partObj = JSONObject().put("text", prompt)
            val partsArray = JSONArray().put(partObj)
            val contentObj = JSONObject().put("parts", partsArray)
            val contentsArray = JSONArray().put(contentObj)
            val requestJson = JSONObject().put("contents", contentsArray)

            val httpRequest = Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=$apiKey")
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

        return@withContext """
            💡 **Step-by-Step Solution**:
            - **Topic**: $topicName
            - **Correct Answer**: $correctAnswer
            
            1. Apply the fundamental principles of $topicName.
            2. Follow standard step-by-step NTA methodology.
            3. Ensure correct unit conversions.
        """.trimIndent()
    }

    suspend fun askDoubtOrChat(
        userMessage: String,
        selectedExam: String = "NEET/JEE"
    ): String = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext """
                Namaste! Main Gemini hu 👋

                Aapke question "$userMessage" par main aapki bilkul naturally help kar sakta hu! Live Gemini 3.5 Flash AI responses aur instant image/document analysis ke liye AI Studio Secrets me apni Gemini API Key add karein.

                Tab tak aap Mock Tests, PYQ Papers, ya Subject Formulas practice kar sakte hain!
            """.trimIndent()
        }

        try {
            val systemInstructionText = """
                You are Gemini, an intelligent, friendly, warm, and expert AI tutor and companion for students preparing for $selectedExam.
                You talk naturally, smoothly, and conversationally, just like official Google Gemini in real life.
                Always respond in a natural, friendly, human-like manner. Match the student's language (Hindi, Hinglish, or English).
                Be direct, clear, empathetic, and fast. Avoid stiff, robotic templates unless a structured step-by-step formula solution is requested.
            """.trimIndent()

            val systemInstructionObj = JSONObject().put("parts", JSONArray().put(JSONObject().put("text", systemInstructionText)))
            val partObj = JSONObject().put("text", userMessage)
            val partsArray = JSONArray().put(partObj)
            val contentObj = JSONObject().put("parts", partsArray)
            val contentsArray = JSONArray().put(contentObj)

            val requestJson = JSONObject()
                .put("systemInstruction", systemInstructionObj)
                .put("contents", contentsArray)
                .put("generationConfig", JSONObject().put("temperature", 0.7))

            val httpRequest = Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=$apiKey")
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

        return@withContext "Mujhe abhi connection me issue ho raha hai. Please ek baar fir se try kijiye!"
    }
}
