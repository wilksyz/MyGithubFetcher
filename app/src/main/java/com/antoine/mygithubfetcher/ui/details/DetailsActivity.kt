package com.antoine.mygithubfetcher.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antoine.mygithubfetcher.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        this.configureFragment()
    }

    private fun configureFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.details_fragment_container, DetailsFragment()).commit()
    }
}
