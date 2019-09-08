package com.antoine.mygithubfetcher.ui.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoine.mygithubfetcher.R
import com.antoine.mygithubfetcher.ui.details.branchRecyclerView.BranchListAdapter
import com.antoine.mygithubfetcher.ui.details.contributorRecyclerView.ContributorListAdapter
import kotlinx.android.synthetic.main.fragment_details.view.*

/**
 * A simple [Fragment] subclass.
 */
private const val OWNER = "owner"
private const val NAME = "name"
class DetailsFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mDetailsFragmentViewModel: DetailsViewModel
    private lateinit var mBranchAdapter: BranchListAdapter
    private lateinit var mContributorAdapter: ContributorListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_details, container, false)
        val owner = arguments?.getString(OWNER).toString()
        val name = arguments?.getString(NAME).toString()
        this.configureViewModel()
        this.configureRecyclerView()
        this.getDetails(owner, name, savedInstanceState)

        return mView
    }

    private fun configureViewModel(){
        mDetailsFragmentViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    private fun configureRecyclerView(){
        this.mBranchAdapter = BranchListAdapter()
        val branchRecyclerView = mView.details_fragment_branches_recyclerView
        branchRecyclerView.adapter = mBranchAdapter
        branchRecyclerView.layoutManager = LinearLayoutManager(this.context)
        this.mContributorAdapter = ContributorListAdapter()
        val contributorRecyclerView = mView.details_fragment_contributors_recyclerView
        contributorRecyclerView.adapter = mContributorAdapter
        contributorRecyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    // Get the branches and the contributors of repository
    private fun getDetails(
        owner: String,
        name: String,
        savedInstanceState: Bundle?
    ) {
        if (savedInstanceState == null){
            mDetailsFragmentViewModel.getContributors(owner, name).observe(viewLifecycleOwner, Observer {contributorsList ->
                mContributorAdapter.updateData(contributorsList)
            })
            mDetailsFragmentViewModel.getBranches(owner, name).observe(viewLifecycleOwner, Observer {branchesList ->
                mBranchAdapter.updateData(branchesList)
            })
        }else {
            mDetailsFragmentViewModel.restoreContributors()?.let { mContributorAdapter.updateData(it) }
            mDetailsFragmentViewModel.restoreBranches()?.let { mBranchAdapter.updateData(it) }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putAll(outState)
        }
        super.onSaveInstanceState(outState)
    }
}
