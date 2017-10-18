package com.djekgrif.kotlin.example.ui.base

import javax.inject.Inject

/**
 * Created by djek-grif on 8/6/17.
 */
abstract class BasePresenterFragment<P : BasePresenter> : BaseFragment() {

    @Inject lateinit var presenter : P

    override fun onStart() {
        super.onStart()
        presenter.subscribe()
    }

    override fun onStop() {
        super.onStop()
        presenter.unSubscribe()
    }
}