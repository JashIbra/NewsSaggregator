package com.newsaggregator.di

import com.newsaggregator.api.RssNewsFeed
import com.newsaggregator.newsfeed.repository.MainRepositoryImpl
import com.newsaggregator.newsfeed.repository.MainRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun dataModule() = module {
    single { getRetrofit().create(RssNewsFeed::class.java) }
    singleOf(::MainRepositoryImpl) bind MainRepository::class
}
