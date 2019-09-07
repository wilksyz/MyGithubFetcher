package com.antoine.mygithubfetcher.ui.details.branchRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.antoine.mygithubfetcher.R
import com.antoine.mygithubfetcher.databinding.RecyclerViewBranchesItemBinding
import com.antoine.mygithubfetcher.model.Branch

class BranchListAdapter: RecyclerView.Adapter<BranchListViewHolder>() {

    private var mBranchList: List<Branch> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchListViewHolder {
        val binding: RecyclerViewBranchesItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_view_branches_item, parent, false)
        return BranchListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mBranchList.size
    }

    override fun onBindViewHolder(holder: BranchListViewHolder, position: Int) {
        holder.itemViewBinding.branch = mBranchList[position]
    }

    fun updateData(branchList: List<Branch>){
        mBranchList = branchList
        notifyDataSetChanged()
    }
}