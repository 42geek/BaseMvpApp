package com.company.app.ui.fragments.home

import com.company.app.data.repository.AndroidDisposable
import com.company.app.data.repository.Repository
import com.company.app.utils.app.disposeBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FragmentHomePresenter @Inject constructor(private val view: FragmentHomeContractor.View,
                                                private val repository: Repository,
                                                private val androidDisposable: AndroidDisposable): FragmentHomeContractor.Presenter {

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun getGitDataFromRepository(since: Int) {
        repository.getGithubReposList(since).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.updateRepoRecyclerViewWithNewData(it)
            }, {
                if (!androidDisposable.isDisposed()) {
                  //TODO: Handle error here
                }
            }, {
            }).disposeBy(androidDisposable)
    }
}