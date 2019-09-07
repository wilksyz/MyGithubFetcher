package com.antoine.mygithubfetcher.repository

import com.antoine.mygithubfetcher.api.GithubStream
import com.antoine.mygithubfetcher.models.Repos
import io.reactivex.Observable

class RepoRepository {

    fun getSearch(query: String): Observable<Repos> {
        return GithubStream.getSearch(query)
    }
}