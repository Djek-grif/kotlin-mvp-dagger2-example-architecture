package icom.djekgrif.kotlin.example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.djekgrif.kotlin.example.App
import com.djekgrif.kotlin.example.R
import com.djekgrif.kotlin.example.di.components.HomeModule
import com.djekgrif.kotlin.example.ui.base.BasePresenterFragment

/**
 * Created by djek-grif on 5/19/17.
 */
class HomeFragment : BasePresenterFragment<HomeContract.Presenter>(), HomeContract.View{

    lateinit var fab : View
    lateinit var progress : View
    lateinit var searchPattern : EditText
    lateinit var message : TextView

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun injectComponent() {
        App.instance.appComponent.plus(HomeModule(this)).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        fab = view.findViewById(R.id.fab)
        progress = view.findViewById(R.id.progress)
        searchPattern = view.findViewById(R.id.search_pattern) as EditText
        message = view.findViewById(R.id.message) as TextView
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener { presenter.onClickGoButton(searchPattern.text.toString()) }
    }

    override fun setLoadingIndicator(active: Boolean) {
        progress.visibility = if(active) View.VISIBLE else View.GONE
    }

    override fun setMessage(text : String) {
        message.text = text
    }

    override fun isHandleBackPressed(): Boolean = false
}