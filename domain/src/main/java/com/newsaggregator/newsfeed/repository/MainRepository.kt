package com.newsaggregator.newsfeed.repository

import com.newsaggregator.newsfeed.model.RssModel

interface MainRepository {
    suspend fun getNewsByCategory(category: String): RssModel
}
