package com.antoine.mygithubfetcher.api

import com.antoine.mygithubfetcher.model.Branch
import com.antoine.mygithubfetcher.model.Contributor
import com.antoine.mygithubfetcher.model.Repo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

object GithubStream {


    fun getSearch(query: String): Observable<Repo> {
        val githubApiService: GithubService = GithubService.retrofit.create(GithubService::class.java)
        return githubApiService.searchRepos(query, 100).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(30, TimeUnit.SECONDS)
    }

    fun getContributors(owner: String, name: String): Observable<List<Contributor>> {
        val githubApiService: GithubService = GithubService.retrofit.create(GithubService::class.java)
        return githubApiService.getContributors(owner, name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(30, TimeUnit.SECONDS)
    }

    fun getBranches(owner: String, name: String): Observable<List<Branch>> {
        val githubApiService: GithubService = GithubService.retrofit.create(GithubService::class.java)
        return githubApiService.getBranches(owner, name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(30, TimeUnit.SECONDS)
    }
}