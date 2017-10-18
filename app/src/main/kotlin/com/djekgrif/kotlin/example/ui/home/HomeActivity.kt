package com.djekgrif.kotlin.example.ui.home

import com.djekgrif.kotlin.example.App
import com.djekgrif.kotlin.example.di.components.HomeModule
import com.djekgrif.kotlin.example.ui.base.SingleFragmentActivity
import icom.djekgrif.kotlin.example.ui.home.HomeContract
import icom.djekgrif.kotlin.example.ui.home.HomeFragment

/**
 * Created by djek-grif on 5/19/17.
 */
class HomeActivity : SingleFragmentActivity<HomeContract.View>() {

    override fun onCreateFragment(): HomeFragment {
        return HomeFragment.newInstance()
    }

}