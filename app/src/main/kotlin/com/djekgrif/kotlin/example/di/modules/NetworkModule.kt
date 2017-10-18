package com.djekgrif.kotlin.example.di.modules

import dagger.Module
import dagger.Provides
import com.djekgrif.kotlin.example.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by djek-grif on 5/22/17.
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkhttp(): OkHttpClient {
//        val cacheSize = 1024 * 1024 * 10L
//        val cacheDir = File(app.cacheDir, "http")
//        val cache = Cache(cacheDir, cacheSize)
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(20, TimeUnit.SECONDS)
        builder.readTimeout(20, TimeUnit.SECONDS)
        builder.writeTimeout(20, TimeUnit.SECONDS)
//        builder.sslSocketFactory(buildSSLSocketFactory(x509TrustManager))
        if(BuildConfig.DEBUG){
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }
        return OkHttpClient.Builder()
//                .cache(cache)
                .build()
    }
}