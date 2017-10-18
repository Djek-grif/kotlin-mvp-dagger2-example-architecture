package com.djekgrif.kotlin.example.di.components

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import com.djekgrif.kotlin.example.di.ActivityScope
import com.djekgrif.kotlin.example.ui.home.HomeActivity
import com.djekgrif.kotlin.example.ui.home.HomePresenter
import icom.djekgrif.kotlin.example.ui.home.HomeContract
import icom.djekgrif.kotlin.example.ui.home.HomeFragment

/**
 * Created by djek-grif on 5/22/17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(activity: HomeActivity)
    fun inject(fragment: HomeFragment)
}

@Module
class HomeModule(private val view: HomeContract.View) {
    @Provides fun provideView(): HomeContract.View  = view
    @Provides fun providePresenter() : HomeContract.Presenter = HomePresenter(view)
}