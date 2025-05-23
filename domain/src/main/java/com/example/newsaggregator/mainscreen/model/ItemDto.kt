package com.example.newsaggregator.mainscreen.model

data class ItemDto(
    val title: String,
    val link: String,
    val description: String,
    val categories: List<CategoryDto>,
    val pubDate: String,
    val guid: String,
    val contents: List<ContentDto>,
    val dcCreator: String,
    val dcDate: String
)
