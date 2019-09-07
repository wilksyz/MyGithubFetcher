package com.antoine.mygithubfetcher.ui.search.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.antoine.mygithubfetcher.R
import com.antoine.mygithubfetcher.databinding.RecyclerViewItemListRepositoryBinding
import com.antoine.mygithubfetcher.models.Item

class RepositoryListAdapter(private val context: Context?): RecyclerView.Adapter<RepositoryListViewHolder>() {

    private var mRepoList: MutableList<Item> = ArrayList()

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
            Toast.makeText(context,"Click at the position: $position", Toast.LENGTH_LONG).show()
        }
    }

    fun updateData(repoList: List<Item>){
        mRepoList = repoList as MutableList<Item>
        notifyDataSetChanged()
    }
}