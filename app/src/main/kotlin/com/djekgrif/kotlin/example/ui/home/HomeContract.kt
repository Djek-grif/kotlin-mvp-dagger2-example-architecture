package icom.djekgrif.kotlin.example.ui.home

import com.djekgrif.kotlin.example.ui.base.BasePresenter
import com.djekgrif.kotlin.example.ui.base.BaseView

/**
 * Created by djek-grif on 5/19/17.
 */
interface HomeContract {

    interface View : BaseView{
        fun setLoadingIndicator(active: Boolean)
        fun setMessage(text : String)
    }

    interface Presenter : BasePresenter {
        fun onClickGoButton(text: String)
    }
}