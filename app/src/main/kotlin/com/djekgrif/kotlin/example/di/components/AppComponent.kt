package com.djekgrif.kotlin.example.di.components

import com.djekgrif.kotlin.example.App
import com.djekgrif.kotlin.example.di.modules.ApiModule
import com.djekgrif.kotlin.example.di.modules.AppModule
import com.djekgrif.kotlin.example.di.modules.DataModule
import com.djekgrif.kotlin.example.ui.home.HomePresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by djek-grif on 5/22/17.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class, DataModule::class))
interface AppComponent {
    fun inject(app: App)
    fun inject(homePresenter: HomePresenter)

    fun plus(module: HomeModule): HomeComponent
}