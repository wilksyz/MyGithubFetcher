package com.antoine.mygithubfetcher.ui.details.contributorRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.antoine.mygithubfetcher.R
import com.antoine.mygithubfetcher.databinding.RecyclerViewContributorsItemBinding
import com.antoine.mygithubfetcher.model.AvatarUrl
import com.antoine.mygithubfetcher.model.Contributor

class ContributorListAdapter: RecyclerView.Adapter<ContributorListViewHolder>() {

    private var mContributorList: List<Contributor> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorListViewHolder {
        val binding: RecyclerViewContributorsItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            , R.layout.recycler_view_contributors_item,
            parent, false)
        return ContributorListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mContributorList.size
    }

    override fun onBindViewHolder(holder: ContributorListViewHolder, position: Int) {
        holder.itemViewBinding.contributor = mContributorList[position]
        val avatarUrl = AvatarUrl
        avatarUrl.imageUrl = mContributorList[position].avatar_url
        holder.itemViewBinding.avatar = avatarUrl
    }

    fun updateData(contributorList: List<Contributor>){
        mContributorList = contributorList
        notifyDataSetChanged()
    }
}