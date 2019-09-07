package com.antoine.mygithubfetcher.models

data class Branch(
    val commit: Commit,
    val name: String,
    val `protected`: Boolean
)