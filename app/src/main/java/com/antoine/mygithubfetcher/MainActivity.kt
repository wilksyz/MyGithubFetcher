package com.antoine.mygithubfetcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antoine.mygithubfetcher.ui.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.configureFragment()
    }

    private fun configureFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.search_fragment_container, SearchFragment()).commit()
    }
}
