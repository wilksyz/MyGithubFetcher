package com.antoine.mygithubfetcher.repository

import com.antoine.mygithubfetcher.api.GithubStream
import com.antoine.mygithubfetcher.model.Branch
import com.antoine.mygithubfetcher.model.Contributor
import com.antoine.mygithubfetcher.model.Repo
import io.reactivex.Observable

class RepoRepository {

    // Call the stream for search repositories
    fun getSearch(query: String): Observable<Repo> {
        return GithubStream.getSearch(query)
    }

    // Get the contributors of repository
    fun getContributors(owner: String, name: String): Observable<List<Contributor>> {
        return GithubStream.getContributors(owner, name)
    }

    // Get the branches of repository
    fun getBranches(owner: String, name: String): Observable<List<Branch>> {
        return GithubStream.getBranches(owner, name)
    }
}