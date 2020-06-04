package com.company.app.ui.activities.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.injection.AppComponent

/**
 * A base activity to use globally to take care for boring stuff like data binding and other stuff...
 */
abstract class BaseActivity<B: ViewDataBinding>: AppCompatActivity() {

    protected lateinit var dataBinding: B


    abstract fun injectDependencies(appComponent: AppComponent)

    abstract fun getLayoutId(): Int

    abstract fun onFinishCreatingBaseActivity()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(ApplicationStarter.appComponent)
        bindViews()
        onFinishCreatingBaseActivity()
    }

    private fun bindViews() {
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

}