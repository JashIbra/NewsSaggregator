package com.newsaggregator.newsfeed.di

import com.newsaggregator.newsfeed.usecase.GetNewsFeedUseCase
import org.koin.dsl.module

fun newsFeedDomainModule () = module {
    single { GetNewsFeedUseCase(get()) }
}
