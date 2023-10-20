package com.androidcourse.data.di

import android.os.Build
import com.androidcourse.data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideLoggInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideHeaderInterceptor() = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("User-Agent", System.getProperty("http.agent") ?: "empty")
            .addHeader("x-device-type", Build.DEVICE)
            .build()
        chain.proceed(request)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        headerInterceptor: Interceptor,
        loggInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(loggInterceptor).build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_PRINCIPAL_PATH)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideAPIInstance(retrofit: Retrofit): com.androidcourse.data.datasource.remote.api.retrofit.ApplicationAPIInterface =
        retrofit.create(com.androidcourse.data.datasource.remote.api.retrofit.ApplicationAPIInterface::class.java)
}
