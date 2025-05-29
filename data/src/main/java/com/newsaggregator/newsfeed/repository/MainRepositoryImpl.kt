package com.newsaggregator.newsfeed.repository

import com.newsaggregator.api.RssNewsFeed
import com.newsaggregator.newsfeed.model.RssModel
import com.newsaggregator.newsfeed.model.toDomain

class MainRepositoryImpl(private val rssNewsFeed: RssNewsFeed): MainRepository {
    override suspend fun getNewsByCategory(category: String): RssModel {
        return rssNewsFeed.getNewsByCategory(category).toDomain()
    }
}
