package com.newsaggregator.newsfeed.model

data class ChannelModel(
    val title: String,
    val link: String,
    val description: String,
    val language: String,
    val copyright: String,
    val pubDate: String,
    val dcDate: String,
    val dcLanguage: String,
    val dcRights: String,
    val image: ImageModel,
    val items: List<ItemModel>,
)
