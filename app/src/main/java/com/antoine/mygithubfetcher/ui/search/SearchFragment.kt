package com.antoine.mygithubfetcher.ui.search


import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoine.mygithubfetcher.R
import com.antoine.mygithubfetcher.ui.details.DetailsActivity
import com.antoine.mygithubfetcher.ui.search.recyclerView.ClickListener
import com.antoine.mygithubfetcher.ui.search.recyclerView.RepositoryListAdapter
import kotlinx.android.synthetic.main.fragment_search.view.*

/**
 * A simple [Fragment] subclass.
 */
private const val OWNER = "owner"
private const val NAME = "name"
class SearchFragment : Fragment(), ClickListener {

    private lateinit var mView: View
    private lateinit var mSearchFragmentViewModel: SearchViewModel
    private lateinit var mAdapter: RepositoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_search, container, false)
        this.configureViewModel()
        this.configureRecyclerView()
        if (savedInstanceState != null) this.restoreSaveInstanceState(savedInstanceState)
        this.initSearchInputListener()

        return mView
    }

    // Get the query of user
    private fun getSearch(query: String) {
        mSearchFragmentViewModel.getSearch(query).observe(viewLifecycleOwner, Observer {repoList ->
                mAdapter.updateData(repoList)
        })
    }

    private fun configureViewModel(){
        mSearchFragmentViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    private fun configureRecyclerView(){
        this.mAdapter = RepositoryListAdapter(this)
        val recyclerView = mView.search_fragment_recycler_view
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    override fun onClick(owner: String, name: String) {
        val detailsIntent = Intent(context, DetailsActivity::class.java)
        detailsIntent.putExtra(OWNER, owner)
        detailsIntent.putExtra(NAME, name)
        startActivity(detailsIntent)
    }

    // Initialise the listeners of editText
    private fun initSearchInputListener(){
        mView.search_fragment_query.setOnEditorActionListener { _, actionId, _ ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                this.getSearch(mView.search_fragment_query.text.toString())
                true
            }else{
                false
            }
        }
        mView.search_fragment_query.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                this.getSearch(mView.search_fragment_query.text.toString())
                true
            } else {
                false
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putAll(outState)
        }
        super.onSaveInstanceState(outState)
    }

    private fun restoreSaveInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null){
            val repoList = mSearchFragmentViewModel.restoreData()
            if (repoList != null) {
                mAdapter.updateData(repoList)
            }
        }
    }
}
