package com.antoine.mygithubfetcher.ui.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.antoine.mygithubfetcher.R

/**
 * A simple [Fragment] subclass.
 */
private const val OWNER = "owner"
private const val NAME = "name"
class DetailsFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mDetailsFragmentViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_details, container, false)
        val owner = arguments?.getString(OWNER).toString()
        val name = arguments?.getString(NAME).toString()
        this.configureViewModel()
        this.getDetails(owner, name)

        return mView
    }

    private fun configureViewModel(){
        mDetailsFragmentViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    private fun getDetails(owner: String, name: String) {
        mDetailsFragmentViewModel.getContributors(owner, name).observe(viewLifecycleOwner, Observer {contributorsList ->

        })
        mDetailsFragmentViewModel.getBranches(owner, name).observe(viewLifecycleOwner, Observer {branchesList ->

        })
    }
}
