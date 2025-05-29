package com.newsaggregator.newsfeed.model

data class ContentModel (
    val type: String?,
    val width: String?,
    val url: String,
    val credit: CreditModel?,
)
