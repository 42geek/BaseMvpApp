package com.company.app.ui.fragments.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.app.data.apis.github.pojos.GithubRepo
import com.company.app.databinding.ItemGithubRepoListBinding

class ReposRecyclerViewAdapter(private val context: Context,
                               private val itemsList: List<GithubRepo>,
                               private val reposRecyclerViewListener: ReposRecyclerViewListener): RecyclerView.Adapter<ReposRecyclerViewAdapter.RepoViewHolder>() {

    private companion object {
        const val LOAD_MORE_DATA_ITEM_GAP = 50
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val binding = ItemGithubRepoListBinding.inflate(layoutInflater)
        return RepoViewHolder(binding, reposRecyclerViewListener)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(itemsList[position])

        if (itemsList.size - position == LOAD_MORE_DATA_ITEM_GAP) {
            reposRecyclerViewListener.loadMoreData(itemsList.last().id)
        }
    }


    class RepoViewHolder(private val binding: ItemGithubRepoListBinding,
                         private val reposRecyclerViewListener: ReposRecyclerViewListener): RecyclerView.ViewHolder(binding.root) {

        fun bind(githubRepo: GithubRepo) {
            with(binding) {
                name.text = githubRepo.name
                description.text = githubRepo.description
                url.text = githubRepo.htmlUrl

                root.setOnClickListener {
                    reposRecyclerViewListener.onItemClicked(githubRepo)
                }
            }
        }
    }


    interface ReposRecyclerViewListener {
        fun loadMoreData(lastRepoId: Int)
        fun onItemClicked(githubRepo: GithubRepo)
    }

}