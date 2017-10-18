package com.djekgrif.kotlin.example.di.modules

import com.djekgrif.kotlin.example.api.ApiSearchService
import com.djekgrif.kotlin.example.api.ApiService
import com.djekgrif.kotlin.example.api.ApiServiceImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by djek-grif on 5/22/17.
 */
@Module(includes = arrayOf(NetworkModule::class))
class ApiModule {

    companion object {
        const val BASE_URL = "http://sugg.search.yahoo.net" // search url like example
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideSearchService(retrofit: Retrofit): ApiSearchService = retrofit.create(ApiSearchService::class.java)

    @Provides
    @Singleton
    fun provideApiService(searchService: ApiSearchService): ApiService = ApiServiceImpl(searchService)
}