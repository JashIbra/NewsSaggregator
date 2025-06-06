package com.newsaggregator.newsfeed.model

data class ItemModel(
    val title: String,
    val link: String,
    val description: String,
    val categories: List<CategoryModel>,
    val pubDate: String,
    val guid: String,
    val contents: List<ContentModel>,
    val dcCreator: String,
    val dcDate: String
)
