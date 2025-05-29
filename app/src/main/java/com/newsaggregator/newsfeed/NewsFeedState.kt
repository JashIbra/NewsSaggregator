package com.newsaggregator.newsfeed

import com.newsaggregator.newsfeed.model.NewsFeedType
import com.newsaggregator.newsfeed.model.RssModel

data class NewsFeedState(
    val url: String? = null,
    val categoryNum: Int = 0,
    val newsType: NewsFeedType = NewsFeedType.News,
    val rssModel: RssModel? = null,
    val isLoading: Boolean = false,
)
