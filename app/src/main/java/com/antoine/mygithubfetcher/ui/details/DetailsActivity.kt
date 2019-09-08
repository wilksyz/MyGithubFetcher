package com.antoine.mygithubfetcher.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.antoine.mygithubfetcher.R

private const val OWNER = "owner"
private const val NAME = "name"
class DetailsActivity : AppCompatActivity() {

    private lateinit var detailsFragment: DetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val owner = intent?.getStringExtra(OWNER)
        val name = intent?.getStringExtra(NAME)
        if (savedInstanceState == null){
            this.configureFragment(owner, name)
        }else {
            detailsFragment = supportFragmentManager.findFragmentById(R.id.details_fragment_container) as DetailsFragment
        }
    }

    private fun configureFragment(owner: String?, name: String?){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        detailsFragment = DetailsFragment()
        val args = Bundle()
        args.putString(OWNER, owner)
        args.putString(NAME, name)
        detailsFragment.arguments = args
        fragmentTransaction.add(R.id.details_fragment_container, detailsFragment)
        fragmentTransaction.commit()
    }
}
