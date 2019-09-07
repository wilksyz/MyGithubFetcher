package com.antoine.mygithubfetcher.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.antoine.mygithubfetcher.api.GithubStream
import com.antoine.mygithubfetcher.models.Repos
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

class SearchViewModel: ViewModel() {

    lateinit var mDisposable: Disposable

    fun getSearch(query: String){
        mDisposable = GithubStream.getSearch(query).subscribeWith(object: DisposableObserver<Repos>() {
            override fun onNext(repository: Repos) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(e: Throwable) {
                Log.e("TAG","On Error",e)
            }

            override fun onComplete() {
                Log.i("TAG","On Complete !!")
            }
        })
    }

}