package com.antoine.mygithubfetcher.ui.search.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.antoine.mygithubfetcher.R
import com.antoine.mygithubfetcher.databinding.RecyclerViewItemListRepositoryBinding
import com.antoine.mygithubfetcher.model.Item

class RepositoryListAdapter(private val listener: ClickListener): RecyclerView.Adapter<RepositoryListViewHolder>() {

    private var mRepoList: List<Item> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListViewHolder {
        val binding: RecyclerViewItemListRepositoryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_view_item_list_repository, parent, false)
        return RepositoryListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mRepoList.size
    }

    override fun onBindViewHolder(holder: RepositoryListViewHolder, position: Int) {
        holder.itemViewBinding.repo = mRepoList[position]
        holder.itemViewBinding.cardView.setOnClickListener {
            listener.onClick(mRepoList[position].owner.login, mRepoList[position].name)
        }
    }

    fun updateData(repoList: List<Item>){
        mRepoList = repoList as MutableList<Item>
        notifyDataSetChanged()
    }
}
interface ClickListener{
    fun onClick(owner: String, name: String)
}