package com.djekgrif.kotlin.example.di.modules

import com.djekgrif.kotlin.example.api.ApiService
import com.djekgrif.kotlin.example.data.DataRepository
import com.djekgrif.kotlin.example.data.DataRepositoryImpl
import dagger.Module
import dagger.Provides

/**
 * Created by djek-grif on 5/22/17.
 */
@Module(includes = arrayOf(AppModule::class))
class DataModule{

    @Provides
    fun provideDataRepository(apiService: ApiService): DataRepository{
        return DataRepositoryImpl(apiService)
    }
}