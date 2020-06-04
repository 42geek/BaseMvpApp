package com.company.app.ui.fragments.home

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.app.R
import com.company.app.appbase.injection.AppComponent
import com.company.app.data.apis.github.pojos.GithubRepo
import com.company.app.databinding.FragmentHomeBinding
import com.company.app.ui.fragments.base.BaseFragment
import com.company.app.ui.fragments.home.di.FragmentHomeModule
import javax.inject.Inject


class FragmentHome: BaseFragment<FragmentHomeBinding>(false), FragmentHomeContractor.View {

    @Inject
    internal lateinit var presenter: FragmentHomeContractor.Presenter

    private val reposRecyclerViewData = mutableListOf<GithubRepo>()
    private lateinit var reposRecyclerViewAdapter: ReposRecyclerViewAdapter

    /**
     * Android lifecycle and super class functions:
     */
    override fun getToolbarView(): View? {
        return null
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(FragmentHomeModule(this)).inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initFragmentViews() {
        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        presenter.getGitDataFromRepository(0)
    }

    override fun updateRepoRecyclerViewWithNewData(data: List<GithubRepo>) {
        reposRecyclerViewData.addAll(data)
        reposRecyclerViewAdapter.notifyDataSetChanged()
    }




    /**
     * Private functions:
     */
    private fun initRecyclerView() {
        dataBinding.reposRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        reposRecyclerViewAdapter = ReposRecyclerViewAdapter(requireContext(), reposRecyclerViewData, getReposRecyclerViewListener())
        dataBinding.reposRecyclerView.adapter = reposRecyclerViewAdapter
    }

    private fun getReposRecyclerViewListener(): ReposRecyclerViewAdapter.ReposRecyclerViewListener {
        return object: ReposRecyclerViewAdapter.ReposRecyclerViewListener{
            override fun loadMoreData(lastRepoId: Int) {
                //The +1 is to make sure to not get the last item in the list again.
                presenter.getGitDataFromRepository(lastRepoId + 1)
            }

            override fun onItemClicked(githubRepo: GithubRepo) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(githubRepo.htmlUrl)
                startActivity(intent)
            }
        }
    }
}