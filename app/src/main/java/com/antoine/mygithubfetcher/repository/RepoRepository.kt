package com.antoine.mygithubfetcher.repository

import com.antoine.mygithubfetcher.api.GithubStream
import com.antoine.mygithubfetcher.models.Repo
import io.reactivex.Observable

class RepoRepository {

    fun getSearch(query: String): Observable<Repo> {
        return GithubStream.getSearch(query)
    }
}