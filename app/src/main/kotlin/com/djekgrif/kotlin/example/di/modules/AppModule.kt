package com.djekgrif.kotlin.example.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import com.djekgrif.kotlin.example.App
import com.djekgrif.kotlin.example.di.AppContext
import javax.inject.Singleton

/**
 * Created by djek-grif on 5/22/17.
 */
@Module
class AppModule(private val app : App) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }

    @Provides
    @AppContext
    internal fun provideContext(): Context {
        return app
    }
}