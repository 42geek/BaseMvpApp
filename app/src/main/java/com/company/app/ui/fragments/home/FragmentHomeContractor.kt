package com.company.app.ui.fragments.home

import com.company.app.data.apis.github.pojos.GithubRepo

interface FragmentHomeContractor {

    interface View {
        fun updateRepoRecyclerViewWithNewData(data: List<GithubRepo>)
    }

    interface Presenter {
        fun subscribe()
        fun unsubscribe()

        fun getGitDataFromRepository(since: Int)
    }
}