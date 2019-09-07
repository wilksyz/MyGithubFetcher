package com.antoine.mygithubfetcher.repository

import com.antoine.mygithubfetcher.api.GithubStream
import com.antoine.mygithubfetcher.models.Branch
import com.antoine.mygithubfetcher.models.Contributor
import com.antoine.mygithubfetcher.models.Repo
import io.reactivex.Observable

class RepoRepository {

    fun getSearch(query: String): Observable<Repo> {
        return GithubStream.getSearch(query)
    }

    fun getContributors(owner: String, name: String): Observable<Contributor> {
        return GithubStream.getContributors(owner, name)
    }

    fun getBranches(owner: String, name: String): Observable<Branch> {
        return GithubStream.getBranches(owner, name)
    }
}