package com.company.app.data.repository

import android.net.Uri
import com.company.app.appbase.ApplicationStarter
import com.company.app.data.apis.github.GithubApiService
import com.company.app.data.apis.github.pojos.GithubRepo
import com.company.app.data.room.LocalDatabase
import com.company.app.data.room.entities.RepoSettings
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * The Repository is responsible to get the app data from any data source, remote or local.
 */

class Repository @Inject constructor(private val applicationStarter: ApplicationStarter,
                                     private val localDatabase: LocalDatabase,
                                     retrofitBuilder: Retrofit.Builder) {


    private companion object {
        const val API_GITHUB_SCHEME = "https"
        const val API_GITHUB_SERVER = "api.github.com"
    }

    private val githubApi = retrofitBuilder
        .client(getHttpClient())
        .baseUrl(getGithubApiServerUrl())
        .build().create(GithubApiService::class.java)


    /**
     * Github API related functions:
     */
    private fun getGithubApiServerUrl(): String {
        return Uri.Builder().scheme(API_GITHUB_SCHEME).authority(API_GITHUB_SERVER).build().toString()
    }

    //Get an observable with github repos:
    fun getGithubReposList(since: Int): Observable<List<GithubRepo>> = githubApi.getListOfRepos(since)



    /**
     * Local Room Database
     */
    fun getUserLocalRepoSettings(): Observable<List<RepoSettings>> {
        return localDatabase.repoSettingsDao().getAllRepoSettings()
    }

    fun addUserLocalRepoSettings(repoSettings: RepoSettings) {
        localDatabase.repoSettingsDao().insertRepoSettings(repoSettings)
    }


    /**
     * General repository helper functions:
     */
    //Get a OkHttp 3 client
    private fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(NetworkInterceptor()).build()
    }

}