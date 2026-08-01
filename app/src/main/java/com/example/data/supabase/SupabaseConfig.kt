package com.example.data.supabase

import android.content.Context
import android.content.SharedPreferences
import com.example.BuildConfig

object SupabaseConfig {

    private const val PREFS_NAME = "supabase_config_prefs"
    private const val KEY_CUSTOM_URL = "custom_supabase_url"
    private const val KEY_CUSTOM_ANON_KEY = "custom_supabase_anon_key"
    private const val KEY_ACCESS_TOKEN = "supabase_access_token"
    private const val KEY_REFRESH_TOKEN = "supabase_refresh_token"
    private const val KEY_USER_EMAIL = "supabase_user_email"
    private const val KEY_USER_ID = "supabase_user_id"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getUrl(context: Context): String {
        val customUrl = getPrefs(context).getString(KEY_CUSTOM_URL, null)
        if (!customUrl.isNullOrBlank()) return customUrl
        
        return try {
            val buildUrl = BuildConfig::class.java.getField("SUPABASE_URL").get(null) as? String
            if (!buildUrl.isNullOrBlank() && buildUrl != "https://your-project.supabase.co") {
                buildUrl
            } else {
                "https://rzundexthupvjusmigas.supabase.co"
            }
        } catch (e: Exception) {
            "https://rzundexthupvjusmigas.supabase.co"
        }
    }

    fun getAnonKey(context: Context): String {
        val customKey = getPrefs(context).getString(KEY_CUSTOM_ANON_KEY, null)
        if (!customKey.isNullOrBlank()) return customKey

        return try {
            val buildKey = BuildConfig::class.java.getField("SUPABASE_ANON_KEY").get(null) as? String
            if (!buildKey.isNullOrBlank() && buildKey != "your-supabase-anon-key") {
                buildKey
            } else {
                "sb_publishable_knS-BlI3zwoMW71aaSXiUw_oJhBbewo"
            }
        } catch (e: Exception) {
            "sb_publishable_knS-BlI3zwoMW71aaSXiUw_oJhBbewo"
        }
    }

    fun saveCustomConfig(context: Context, url: String, anonKey: String) {
        getPrefs(context).edit()
            .putString(KEY_CUSTOM_URL, url.trim().removeSuffix("/"))
            .putString(KEY_CUSTOM_ANON_KEY, anonKey.trim())
            .apply()
    }

    fun saveSession(context: Context, accessToken: String?, refreshToken: String?, userId: String?, email: String?) {
        getPrefs(context).edit()
            .putString(KEY_ACCESS_TOKEN, accessToken)
            .putString(KEY_REFRESH_TOKEN, refreshToken)
            .putString(KEY_USER_ID, userId)
            .putString(KEY_USER_EMAIL, email)
            .apply()
    }

    fun clearSession(context: Context) {
        getPrefs(context).edit()
            .remove(KEY_ACCESS_TOKEN)
            .remove(KEY_REFRESH_TOKEN)
            .remove(KEY_USER_ID)
            .remove(KEY_USER_EMAIL)
            .apply()
    }

    fun getAccessToken(context: Context): String? = getPrefs(context).getString(KEY_ACCESS_TOKEN, null)
    fun getUserId(context: Context): String? = getPrefs(context).getString(KEY_USER_ID, null)
    fun getUserEmail(context: Context): String? = getPrefs(context).getString(KEY_USER_EMAIL, null)

    fun isConfigured(context: Context): Boolean {
        val url = getUrl(context)
        return url.startsWith("http") && !url.contains("your-project")
    }
}
