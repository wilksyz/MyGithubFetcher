package com.antoine.mygithubfetcher.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
