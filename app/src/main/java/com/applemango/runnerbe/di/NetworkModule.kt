package com.applemango.runnerbe.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.applemango.runnerbe.BuildConfig
import com.applemango.runnerbe.network.BearerInterceptor
import com.applemango.runnerbe.network.XAccessTokenInterceptor
import com.applemango.runnerbe.network.api.GetUserDataApi
import com.applemango.runnerbe.screen.compose.login.KakaoLoginAPI
import com.applemango.runnerbe.screen.compose.login.NaverLoginAPI
import java.util.concurrent.TimeUnit

/**
 * author : 두루
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(BearerInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()
    } else {
        OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideKakaoLoginApi(retrofit: Retrofit): KakaoLoginAPI =
        retrofit.create(KakaoLoginAPI::class.java)

    @Provides
    @Singleton
    fun provideNaverLoginApi(retrofit: Retrofit): NaverLoginAPI =
        retrofit.create(NaverLoginAPI::class.java)

    @Provides
    @Singleton
    fun provideUserDataApi(retrofit: Retrofit): GetUserDataApi =
        retrofit.create(GetUserDataApi::class.java)
//
//    @Provides
//    @Singleton
//    fun provideDeleteUserApi(retrofit: Retrofit): DeleteUserAPI =
//        retrofit.create(DeleteUserAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun provideMypageApi(retrofit: Retrofit): MypageAPI =
//        retrofit.create(MypageAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun provideEditNicknameApi(retrofit: Retrofit): EditNicknameAPI =
//        retrofit.create(EditNicknameAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun provideEditjobApi(retrofit: Retrofit): EditJobAPI =
//        retrofit.create(EditJobAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun providePatchUserImgApi(retrofit: Retrofit): PatchUserImgAPI =
//        retrofit.create(PatchUserImgAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun provideScrapApi(retrofit: Retrofit): GetScrapAPI =
//        retrofit.create(GetScrapAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun provideBookmarkApi(retrofit: Retrofit): PostBookmarkAPI =
//        retrofit.create(PostBookmarkAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun providePatchAlarmApi(retrofit: Retrofit): PatchAlarmAPI =
//        retrofit.create(PatchAlarmAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun provideGetMessageApi(retrofit: Retrofit): GetMessageAPI =
//        retrofit.create(GetMessageAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun provideGetAlarmApi(retrofit: Retrofit): GetAlarmAPI =
//        retrofit.create(GetAlarmAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun providePostReportApi(retrofit: Retrofit): PostReportAPI =
//        retrofit.create(PostReportAPI::class.java)
//
//    @Provides
//    @Singleton
//    fun providePostMessageApi(retrofit: Retrofit): PostMessageAPI =
//        retrofit.create(PostMessageAPI::class.java)
}