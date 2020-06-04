package com.company.app.ui.activities.main.di

import com.company.app.appbase.injection.scope.PerActivity
import com.company.app.appbase.injection.scope.PerFragment
import com.company.app.data.repository.AndroidDisposable
import com.company.app.ui.activities.main.MainActivityContractor
import com.company.app.ui.activities.main.MainActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val view: MainActivityContractor.View) {

    @Provides
    @PerActivity
    fun provideView(): MainActivityContractor.View = view

    @Provides
    @PerActivity
    fun providePresenter(view: MainActivityContractor.View): MainActivityContractor.Presenter {
        return MainActivityPresenter(view)
    }

    @Provides
    @PerActivity
    fun provideAndroidDisposable(): AndroidDisposable = AndroidDisposable()

}