package com.antoine.mygithubfetcher.api

import com.antoine.mygithubfetcher.models.Branch
import com.antoine.mygithubfetcher.models.Contributor
import com.antoine.mygithubfetcher.models.Repo
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String, @Query("per_page") page: Int): Observable<Repo>

    @GET("repos/{owner}/{name}/branches")
    fun getBranches(@Path("owner") owner: String, @Path("name") name: String): Observable<List<Branch>>

    @GET("repos/{owner}/{name}/contributors")
    fun getContributors(@Path("owner") owner: String, @Path("name") name: String): Observable<List<Contributor>>

    companion object {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}