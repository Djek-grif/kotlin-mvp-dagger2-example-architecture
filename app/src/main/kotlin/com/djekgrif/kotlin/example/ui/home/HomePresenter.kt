package com.djekgrif.kotlin.example.ui.home

import android.text.TextUtils
import com.djekgrif.kotlin.example.App
import com.djekgrif.kotlin.example.data.DataRepository
import com.djekgrif.kotlin.example.ui.base.BasePresenterImpl
import com.djekgrif.kotlin.example.utils.Logger
import icom.djekgrif.kotlin.example.ui.home.HomeContract
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by djek-grif on 5/18/17.
 */
class HomePresenter(view: HomeContract.View) : BasePresenterImpl<HomeContract.View>(view), HomeContract.Presenter {

    @Inject lateinit var dataRepository: DataRepository

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onClickGoButton(text : String) {
        dataRepository.getSearchSuggestion(5, text)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.setLoadingIndicator(true) }
                .doOnComplete { view.setLoadingIndicator(false) }
                .subscribe({ result ->
                    Logger.d("We have search result: $result")
                        view.setMessage(TextUtils.join(", ", result.gossip.results))
                })
    }

}