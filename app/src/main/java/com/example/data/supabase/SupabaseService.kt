package com.example.data.supabase

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Headers
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.concurrent.TimeUnit

class SupabaseService(private val context: Context) {

    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val JSON_MEDIA_TYPE = "application/json; charset=utf-8".toMediaType()

    private fun buildHeaders(): Headers {
        val anonKey = SupabaseConfig.getAnonKey(context)
        val token = SupabaseConfig.getAccessToken(context) ?: anonKey

        return Headers.Builder()
            .add("apikey", anonKey)
            .add("Authorization", "Bearer $token")
            .add("Content-Type", "application/json")
            .add("Prefer", "return=representation")
            .build()
    }

    // --- Supabase Auth ---

    suspend fun signUp(email: String, pass: String): Result<SupabaseAuthResponse> = withContext(Dispatchers.IO) {
        val url = "${SupabaseConfig.getUrl(context)}/auth/v1/signup"
        val requestBody = moshi.adapter(SupabaseAuthRequest::class.java)
            .toJson(SupabaseAuthRequest(email, pass))
            .toRequestBody(JSON_MEDIA_TYPE)

        val request = Request.Builder()
            .url(url)
            .headers(buildHeaders())
            .post(requestBody)
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val authResp = moshi.adapter(SupabaseAuthResponse::class.java).fromJson(bodyStr)
                    if (authResp != null) {
                        SupabaseConfig.saveSession(
                            context,
                            authResp.accessToken,
                            authResp.refreshToken,
                            authResp.user?.id,
                            authResp.user?.email
                        )
                        Result.success(authResp)
                    } else {
                        Result.failure(Exception("Failed to parse auth response"))
                    }
                } else {
                    Result.failure(Exception("Sign up failed: ${response.code} $bodyStr"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signIn(email: String, pass: String): Result<SupabaseAuthResponse> = withContext(Dispatchers.IO) {
        val url = "${SupabaseConfig.getUrl(context)}/auth/v1/token?grant_type=password"
        val requestBody = moshi.adapter(SupabaseAuthRequest::class.java)
            .toJson(SupabaseAuthRequest(email, pass))
            .toRequestBody(JSON_MEDIA_TYPE)

        val request = Request.Builder()
            .url(url)
            .headers(buildHeaders())
            .post(requestBody)
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val authResp = moshi.adapter(SupabaseAuthResponse::class.java).fromJson(bodyStr)
                    if (authResp != null) {
                        SupabaseConfig.saveSession(
                            context,
                            authResp.accessToken,
                            authResp.refreshToken,
                            authResp.user?.id,
                            authResp.user?.email ?: email
                        )
                        Result.success(authResp)
                    } else {
                        Result.failure(Exception("Failed to parse sign-in token response"))
                    }
                } else {
                    Result.failure(Exception("Invalid credentials or login failed (${response.code})"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --- PostgREST Sync Operations ---

    suspend fun syncTestAttempts(attempts: List<SupabaseTestAttemptDto>): Result<List<SupabaseTestAttemptDto>> = withContext(Dispatchers.IO) {
        if (attempts.isEmpty()) return@withContext Result.success(emptyList())

        val url = "${SupabaseConfig.getUrl(context)}/rest/v1/test_attempts"
        val type = Types.newParameterizedType(List::class.java, SupabaseTestAttemptDto::class.java)
        val jsonStr = moshi.adapter<List<SupabaseTestAttemptDto>>(type).toJson(attempts)

        val request = Request.Builder()
            .url(url)
            .headers(buildHeaders())
            .post(jsonStr.toRequestBody(JSON_MEDIA_TYPE))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val synced = moshi.adapter<List<SupabaseTestAttemptDto>>(type).fromJson(bodyStr) ?: emptyList()
                    Result.success(synced)
                } else {
                    Result.failure(Exception("Sync attempts failed: ${response.code} $bodyStr"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun fetchRemoteTestAttempts(): Result<List<SupabaseTestAttemptDto>> = withContext(Dispatchers.IO) {
        val url = "${SupabaseConfig.getUrl(context)}/rest/v1/test_attempts?select=*"
        val request = Request.Builder()
            .url(url)
            .headers(buildHeaders())
            .get()
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val type = Types.newParameterizedType(List::class.java, SupabaseTestAttemptDto::class.java)
                    val attempts = moshi.adapter<List<SupabaseTestAttemptDto>>(type).fromJson(bodyStr) ?: emptyList()
                    Result.success(attempts)
                } else {
                    Result.failure(Exception("Fetch attempts failed: ${response.code}"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun syncBookmarks(bookmarks: List<SupabaseBookmarkDto>): Result<List<SupabaseBookmarkDto>> = withContext(Dispatchers.IO) {
        if (bookmarks.isEmpty()) return@withContext Result.success(emptyList())

        val url = "${SupabaseConfig.getUrl(context)}/rest/v1/bookmarks"
        val type = Types.newParameterizedType(List::class.java, SupabaseBookmarkDto::class.java)
        val jsonStr = moshi.adapter<List<SupabaseBookmarkDto>>(type).toJson(bookmarks)

        val request = Request.Builder()
            .url(url)
            .headers(buildHeaders())
            .post(jsonStr.toRequestBody(JSON_MEDIA_TYPE))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val synced = moshi.adapter<List<SupabaseBookmarkDto>>(type).fromJson(bodyStr) ?: emptyList()
                    Result.success(synced)
                } else {
                    Result.failure(Exception("Sync bookmarks failed: ${response.code} $bodyStr"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun pushPapers(papers: List<SupabasePaperDto>): Result<List<SupabasePaperDto>> = withContext(Dispatchers.IO) {
        if (papers.isEmpty()) return@withContext Result.success(emptyList())

        val url = "${SupabaseConfig.getUrl(context)}/rest/v1/papers"
        val type = Types.newParameterizedType(List::class.java, SupabasePaperDto::class.java)
        val jsonStr = moshi.adapter<List<SupabasePaperDto>>(type).toJson(papers)

        val headers = buildHeaders().newBuilder()
            .set("Prefer", "resolution=merge-duplicates,return=representation")
            .build()

        val request = Request.Builder()
            .url(url)
            .headers(headers)
            .post(jsonStr.toRequestBody(JSON_MEDIA_TYPE))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val synced = moshi.adapter<List<SupabasePaperDto>>(type).fromJson(bodyStr) ?: emptyList()
                    Result.success(synced)
                } else {
                    Result.failure(Exception("Push papers failed: ${response.code} $bodyStr"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun pushQuestions(questions: List<SupabaseQuestionDto>): Result<List<SupabaseQuestionDto>> = withContext(Dispatchers.IO) {
        if (questions.isEmpty()) return@withContext Result.success(emptyList())

        val url = "${SupabaseConfig.getUrl(context)}/rest/v1/questions"
        val type = Types.newParameterizedType(List::class.java, SupabaseQuestionDto::class.java)
        val jsonStr = moshi.adapter<List<SupabaseQuestionDto>>(type).toJson(questions)

        val headers = buildHeaders().newBuilder()
            .set("Prefer", "resolution=merge-duplicates,return=representation")
            .build()

        val request = Request.Builder()
            .url(url)
            .headers(headers)
            .post(jsonStr.toRequestBody(JSON_MEDIA_TYPE))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val synced = moshi.adapter<List<SupabaseQuestionDto>>(type).fromJson(bodyStr) ?: emptyList()
                    Result.success(synced)
                } else {
                    Result.failure(Exception("Push questions failed: ${response.code} $bodyStr"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun fetchAdminNews(): Result<List<SupabaseNewsDto>> = withContext(Dispatchers.IO) {
        val url = "${SupabaseConfig.getUrl(context)}/rest/v1/admin_news?select=*&order=created_at.desc"
        val request = Request.Builder()
            .url(url)
            .headers(buildHeaders())
            .get()
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val type = Types.newParameterizedType(List::class.java, SupabaseNewsDto::class.java)
                    val newsList = moshi.adapter<List<SupabaseNewsDto>>(type).fromJson(bodyStr) ?: emptyList()
                    Result.success(newsList)
                } else {
                    Result.failure(Exception("Fetch news failed: ${response.code}"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun fetchLiveArenaStats(): Result<SupabaseLiveArenaDto> = withContext(Dispatchers.IO) {
        val url = "${SupabaseConfig.getUrl(context)}/rest/v1/live_arena_stats?select=*&order=updated_at.desc&limit=1"
        val request = Request.Builder()
            .url(url)
            .headers(buildHeaders())
            .get()
            .build()

        try {
            client.newCall(request).execute().use { response ->
                val bodyStr = response.body?.string().orEmpty()
                if (response.isSuccessful) {
                    val type = Types.newParameterizedType(List::class.java, SupabaseLiveArenaDto::class.java)
                    val list = moshi.adapter<List<SupabaseLiveArenaDto>>(type).fromJson(bodyStr) ?: emptyList()
                    if (list.isNotEmpty()) {
                        Result.success(list.first())
                    } else {
                        Result.success(SupabaseLiveArenaDto())
                    }
                } else {
                    Result.failure(Exception("Fetch arena stats failed: ${response.code}"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun pingHealth(): Boolean = withContext(Dispatchers.IO) {
        val url = "${SupabaseConfig.getUrl(context)}/rest/v1/"
        val request = Request.Builder()
            .url(url)
            .headers(buildHeaders())
            .head()
            .build()

        try {
            client.newCall(request).execute().use { response ->
                response.isSuccessful || response.code == 401 || response.code == 400
            }
        } catch (e: Exception) {
            false
        }
    }
}
