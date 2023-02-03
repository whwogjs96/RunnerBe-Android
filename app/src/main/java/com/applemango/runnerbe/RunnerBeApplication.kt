package com.applemango.runnerbe

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.applemango.runnerbe.util.TokenSPreference
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility.getKeyHash
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit

@HiltAndroidApp
class RunnerBeApplication: Application() {

    init{
        instance = this
    }

    //두루 코드 사용
    companion object {
        // 만들어져있는 SharedPreferences 를 사용해야합니다. 재생성하지 않도록 유념해주세요
        lateinit var mTokenPreference : TokenSPreference

        // JWT Token Header 키 값
        val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"

        // refresh_token
        val refresh_token = "refresh-token"

        // Retrofit 인스턴스, 앱 실행시 한번만 생성하여 사용합니다.
        lateinit var sRetrofit: Retrofit
        lateinit var instance: RunnerBeApplication
        fun ApplicationContext() : Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // 다크모드 비활성화
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        mTokenPreference = TokenSPreference(applicationContext)


        // fire base settings
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("response!", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            task.result

            Log.d("fcm_response!", token!!)
            mTokenPreference.editor.putString("deviceToken", token)
            mTokenPreference.editor.commit()
        })
    }
}