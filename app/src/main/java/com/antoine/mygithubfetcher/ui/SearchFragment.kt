package com.antoine.mygithubfetcher.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.antoine.mygithubfetcher.R

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_search, container, false)

        return mView
    }


}
