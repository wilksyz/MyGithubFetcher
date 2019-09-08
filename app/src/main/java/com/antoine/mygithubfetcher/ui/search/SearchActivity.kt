package com.antoine.mygithubfetcher.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.antoine.mygithubfetcher.R

class SearchActivity : AppCompatActivity() {

    private lateinit var searchFragment: SearchFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            this.configureFragment()
        }else {
            searchFragment = supportFragmentManager.findFragmentById(R.id.search_fragment_container) as SearchFragment
        }
    }

    private fun configureFragment(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        searchFragment = SearchFragment()
        fragmentTransaction.add(R.id.search_fragment_container, searchFragment)
        fragmentTransaction.commit()
    }
}
