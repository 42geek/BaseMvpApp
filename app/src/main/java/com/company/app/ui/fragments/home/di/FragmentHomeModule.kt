package com.company.app.ui.fragments.home.di

import com.company.app.appbase.injection.scope.PerFragment
import com.company.app.data.repository.AndroidDisposable
import com.company.app.data.repository.Repository
import com.company.app.ui.fragments.home.FragmentHomeContractor
import com.company.app.ui.fragments.home.FragmentHomePresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentHomeModule(private val view: FragmentHomeContractor.View) {

    @Provides
    @PerFragment
    fun provideView(): FragmentHomeContractor.View = view

    @Provides
    @PerFragment
    fun providePresenter(repository: Repository, androidDisposable: AndroidDisposable): FragmentHomeContractor.Presenter = FragmentHomePresenter(view, repository, androidDisposable)

    @Provides
    @PerFragment
    fun provideAndroidDisposable(): AndroidDisposable = AndroidDisposable()

}