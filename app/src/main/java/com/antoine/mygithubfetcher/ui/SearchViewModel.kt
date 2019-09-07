package com.antoine.mygithubfetcher.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.antoine.mygithubfetcher.models.Item
import com.antoine.mygithubfetcher.models.Repo
import com.antoine.mygithubfetcher.repository.RepoRepository
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

private const val TAG = "SEARCH_VIEW_MODEL"
class SearchViewModel: ViewModel() {

    private val mRepoRepository = RepoRepository()
    lateinit var mDisposable: Disposable
    private val mRepoList: MutableLiveData<List<Item>> = MutableLiveData()

    fun getSearch(query: String): MutableLiveData<List<Item>> {
        mDisposable = mRepoRepository.getSearch(query).subscribeWith(object: DisposableObserver<Repo>() {
            override fun onNext(repository: Repo) {
                mRepoList.value = repository.items
            }

            override fun onError(e: Throwable) {
                Log.e(TAG,"On Error",e)
            }

            override fun onComplete() {
                Log.i(TAG,"On Complete !!")
            }
        })
        return mRepoList
    }
}