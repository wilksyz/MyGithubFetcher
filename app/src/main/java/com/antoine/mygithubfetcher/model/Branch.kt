package com.antoine.mygithubfetcher.model

data class Branch(
    val commit: Commit,
    val name: String,
    val `protected`: Boolean
)