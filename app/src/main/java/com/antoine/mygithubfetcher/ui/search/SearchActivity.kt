package com.antoine.mygithubfetcher.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.antoine.mygithubfetcher.R

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.configureFragment()
    }

    private fun configureFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.search_fragment_container,
            SearchFragment()
        ).commit()
    }
}
