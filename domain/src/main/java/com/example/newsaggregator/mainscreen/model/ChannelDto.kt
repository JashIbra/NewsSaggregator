package com.example.newsaggregator.mainscreen.model

data class ChannelDto(
    val title: String,
    val link: String,
    val description: String,
    val language: String,
    val copyright: String,
    val pubDate: String,
    val dcDate: String,
    val dcLanguage: String,
    val dcRights: String,
    val image: ImageDto,
    val items: List<ItemDto>,
)
