package com.antoine.mygithubfetcher.ui.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.antoine.mygithubfetcher.model.Branch
import com.antoine.mygithubfetcher.model.Contributor
import com.antoine.mygithubfetcher.repository.RepoRepository
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

private const val TAG = "DETAILS_VIEW_MODEL"
class DetailsViewModel: ViewModel() {

    private val mRepoRepository = RepoRepository()
    lateinit var mDisposable: Disposable
    private val mContributorsList: MutableLiveData<List<Contributor>> = MutableLiveData()
    private val mBranchesList: MutableLiveData<List<Branch>> = MutableLiveData()

    fun getContributors(owner: String, name: String): MutableLiveData<List<Contributor>> {
        mDisposable = mRepoRepository.getContributors(owner, name).subscribeWith(object: DisposableObserver<List<Contributor>>() {
            override fun onNext(repository: List<Contributor>) {
                mContributorsList.value = repository
            }

            override fun onError(e: Throwable) {
                Log.e(TAG,"On Error contributors",e)
            }

            override fun onComplete() {
                Log.i(TAG,"On Complete !!")
            }
        })
        return mContributorsList
    }

    fun getBranches(owner: String, name: String): MutableLiveData<List<Branch>> {
        mDisposable = mRepoRepository.getBranches(owner, name).subscribeWith(object: DisposableObserver<List<Branch>>() {
            override fun onNext(repository: List<Branch>) {
                mBranchesList.value = repository
            }

            override fun onError(e: Throwable) {
                Log.e(TAG,"On Error Branches",e)
            }

            override fun onComplete() {
                Log.i(TAG,"On Complete !!")
            }
        })
        return mBranchesList
    }
}