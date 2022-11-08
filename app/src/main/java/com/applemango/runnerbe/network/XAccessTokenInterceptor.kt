package com.applemango.runnerbe.network

import com.applemango.runnerbe.RunnerBeApplication.Companion.sSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * author : 두루
 */
class XAccessTokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sSharedPreferences.getString("X-ACCESS-TOKEN", null)

        // refresh token
        val refreshToken: String? = sSharedPreferences.getString("refresh-token", null)

        if (jwtToken != null) {
            builder.addHeader("x-access-token", jwtToken)
//            if(refreshToken != null){
////                builder.addHeader("Authorization", "Bearer "+jwtToken)
//                // refresh_token
////                builder.addHeader("refresh-token", refreshToken!!)
//            }
        }
        return chain.proceed(builder.build())
    }
}