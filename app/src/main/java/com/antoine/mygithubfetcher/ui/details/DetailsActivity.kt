package com.antoine.mygithubfetcher.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antoine.mygithubfetcher.R

private const val OWNER = "owner"
private const val NAME = "name"
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val owner = intent?.getStringExtra(OWNER)
        val name = intent?.getStringExtra(NAME)
        this.configureFragment(owner, name)
    }

    private fun configureFragment(owner: String?, name: String?) {
        val detailsFragment = DetailsFragment()
        val args = Bundle()
        args.putString(OWNER, owner)
        args.putString(NAME, name)
        detailsFragment.arguments = args
        supportFragmentManager.beginTransaction().replace(R.id.details_fragment_container, detailsFragment).commit()
    }
}
