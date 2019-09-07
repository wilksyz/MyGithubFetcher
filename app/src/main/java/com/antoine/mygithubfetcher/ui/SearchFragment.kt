package com.antoine.mygithubfetcher.ui


import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.antoine.mygithubfetcher.R
import com.antoine.mygithubfetcher.ui.recyclerView.RepositoryListAdapter
import kotlinx.android.synthetic.main.fragment_search.view.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mSearchFragmentViewModel: SearchViewModel
    private lateinit var mAdapter: RepositoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_search, container, false)
        this.configureRecyclerView()
        this.configureViewModel()
        this.initSearchInputListener()

        return mView
    }

    private fun getSearch(query: String) {
        mSearchFragmentViewModel.getSearch(query).observe(viewLifecycleOwner, Observer {repoList ->
            for (repo in repoList){
                mAdapter.updateData(repoList)
            }
        })
    }

    private fun configureViewModel(){
        mSearchFragmentViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    private fun configureRecyclerView(){
        this.mAdapter = RepositoryListAdapter(context)
        val recyclerView = mView.search_fragment_recycler_view
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    private fun initSearchInputListener(){
        mView.search_fragment_query.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                this.getSearch(mView.search_fragment_query.text.toString())
                true
            }else{
                false
            }
        }
        mView.search_fragment_query.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                this.getSearch(mView.search_fragment_query.text.toString())
                true
            } else {
                false
            }
        }
    }
}
