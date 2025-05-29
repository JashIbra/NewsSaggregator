package com.newsaggregator.api

import com.newsaggregator.newsfeed.model.RssDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RssNewsFeed {
    @GET("/{category}/rss")
    suspend fun getNewsByCategory(
        @Path("category") query: String = "international"
    ): RssDto
}
