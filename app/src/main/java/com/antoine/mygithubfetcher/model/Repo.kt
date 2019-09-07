package com.antoine.mygithubfetcher.model

data class Repo(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)