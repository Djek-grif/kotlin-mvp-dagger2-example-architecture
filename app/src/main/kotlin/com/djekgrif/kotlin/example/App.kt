package com.djekgrif.kotlin.example

import android.app.Application
import com.djekgrif.kotlin.example.di.components.AppComponent
import com.djekgrif.kotlin.example.di.components.DaggerAppComponent
import com.djekgrif.kotlin.example.utils.DelegatesExt

/**
 * Created by djek-grif on 5/20/17.
 */
class App : Application(){

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue<App>()
    }

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent
                .builder()
                .build()
        appComponent.inject(this)
    }
}