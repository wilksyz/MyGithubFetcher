package com.antoine.mygithubfetcher.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.antoine.mygithubfetcher.R
import com.antoine.mygithubfetcher.models.Repo
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
        this.sentDataOnRecyclerView()

        mView.search_fragment_query.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                Toast.makeText(context,"Your query: ${mView.search_fragment_query.text}", Toast.LENGTH_LONG).show()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        return mView
    }

    private fun sentDataOnRecyclerView() {
        val repoList = ArrayList<Repo>()
        repoList.add(Repo("MoodTracker", "Display your mood of the day", 6, "Java"))
        repoList.add(Repo("MyNews", "Display the new articles of New York Times", 8, "Java"))
        repoList.add(Repo("Go4Lunch", "Now it's possible to lunch with your friends", 4, "Java"))
        repoList.add(Repo("RealEstateManager", "Save your catalog of property for sale in the Android app", 12, "Kotlin"))
        repoList.add(Repo("GoodCount", "Faites les comptes entre amis facilement", 24, "Kotlin"))
        mAdapter.updateData(repoList)
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
}
