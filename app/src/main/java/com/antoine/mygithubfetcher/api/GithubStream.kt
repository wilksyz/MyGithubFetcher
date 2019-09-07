package com.antoine.mygithubfetcher.api

import com.antoine.mygithubfetcher.models.Repo
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
}