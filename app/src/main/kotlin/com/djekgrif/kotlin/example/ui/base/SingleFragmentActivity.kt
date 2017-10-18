package com.djekgrif.kotlin.example.ui.base

import android.app.Fragment
import android.os.Bundle
import com.djekgrif.kotlin.example.R
import com.djekgrif.kotlin.example.R.layout.activity_single_fragment

/**
 * Created by djek-grif on 5/19/17.
 */
abstract class SingleFragmentActivity<V : BaseView> : BaseActivity(){

    companion object {
        const val FRAGMENT_TAG = "_single_fragment_tag"
    }

    protected lateinit var view: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        injectComponent()
        view = buildView()
    }

    protected fun getLayoutResource(): Int = activity_single_fragment

    @Suppress("UNCHECKED_CAST")
    fun buildView(): V {
        var fragment = fragmentManager.findFragmentById(R.id.fragment_container)
        if(fragment == null) {
            fragment = onCreateFragment()
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment, fragment.javaClass.canonicalName + FRAGMENT_TAG)
                    .commit()
        }
        return fragment as V
    }

    override fun onBackPressed() {
        if(view.isHandleBackPressed().not()) {
            super.onBackPressed()
        }
    }

    protected abstract fun onCreateFragment(): Fragment
    protected fun injectComponent(){}
}