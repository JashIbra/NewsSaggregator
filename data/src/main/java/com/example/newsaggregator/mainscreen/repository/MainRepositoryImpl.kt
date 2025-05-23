package com.example.newsaggregator.mainscreen.repository

import com.example.newsaggregator.api.RssFeed

class MainRepositoryImpl(private val rssFeed: RssFeed): MainRepository {

    suspend fun foo() {
        rssFeed.getRss().channel
    }
}
