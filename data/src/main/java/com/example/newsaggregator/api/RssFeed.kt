package com.example.newsaggregator.api

import com.example.newsaggregator.mainscreen.model.RssDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RssFeed {
    @GET("/{query}/rss")
    suspend fun getRss(
        @Path("query") query: String = "international"
    ): RssDto
}
