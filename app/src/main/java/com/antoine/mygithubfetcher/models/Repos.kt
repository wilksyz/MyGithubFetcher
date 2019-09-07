package com.antoine.mygithubfetcher.models

data class Repos(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)