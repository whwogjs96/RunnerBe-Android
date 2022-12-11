package com.applemango.runnerbe.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.applemango.runnerbe.RunnerBeApplication
import java.util.UUID

class TokenSPreference(private val applicationContext : Context) {
    val sSharedPreferences: SharedPreferences = applicationContext.getSharedPreferences("runnerBe", Application.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sSharedPreferences.edit()

    fun setToken(token : String) {
        editor.putString("X-ACCESS-TOKEN", token)
        editor.commit()
    }

    fun getToken(): String? {
        return sSharedPreferences.getString("X-ACCESS-TOKEN", "")
    }

    fun setRefreshToken(refreshToken : String) {
        editor.putString("refresh-token",refreshToken)
        editor.commit()
    }

    fun getRefreshToken() : String? {
        return sSharedPreferences.getString("refresh-token", "")
    }
    fun setUserId(userId : Int) {
        editor.putInt("userId", userId)
        editor.commit()
    }

    fun getUserId() : Int {
        return sSharedPreferences.getInt("userId", 0)
    }

    fun setUuid(uuid: String) {
        editor.putString("uuid", uuid)
        editor.commit()
    }

    fun getUuid() :String? {
        return sSharedPreferences.getString("uuid","")
    }
}